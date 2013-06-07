package org.una.simpleumlstatemachine.state

import org.una.simpleumlstatemachine.transition.{SignalTransition, ConditionTransition, CompletionTransition, Transition}
import org.una.simpleumlstatemachine.Event
import scala.collection.mutable

/**
 * Created with IntelliJ IDEA.
 * User: cg
 * Date: 6/5/13
 * Time: 5:17 PM
 * To change this template use File | Settings | File Templates.
 */
// Subclasses of this trait are supposed to implement at least one of the continuation package interfaces
abstract class ContinuingState extends State {

  private var completionTransitions = new mutable.LinkedList[CompletionTransition]()
  private var conditionTransitions = new mutable.LinkedList[ConditionTransition]()
  private val signalTransitions = mutable.Map[Event.Event, SignalTransition]().empty

  def addCompletionTransition(c: CompletionTransition) = completionTransitions = completionTransitions :+ c

  def addConditionTransition(c: ConditionTransition) = conditionTransitions = conditionTransitions :+ c

  def addSignalTransition(s: SignalTransition) = signalTransitions update(s.signal, s)

  //TODO: bad impl but we only expect one of these transitions to be present (ATM) -> choice should be random
  protected def nextCompletionTransition(): Option[Transition] = completionTransitions.headOption

  //TODO: bad impl but we only expect one of these transitions to be present (ATM) -> choice should be random
  protected def nextConditionalTransition(): Option[Transition] = conditionTransitions.headOption

  protected def nextSignalTransition(trigger: Event.Event): Option[Transition] = signalTransitions get trigger

  /**
   * If there is COMPLETION transition, an option containing the state returned by executing the COMPLETION transition is returned
   * Else if there is CONDITION transition, an option containing the state returned by executing the CONDITION transition is returned
   * Else None is returned
   * PER CONVENTION THIS METHOD MUST BE CALLED ONLY BEFORE 'signaledTransition' (per state)
   * @return
   */
  def nonSignaledTransition(): Option[State] = {
    nextCompletionTransition match {
      case Some(transition) => Some(transition execute())
      case None => nextConditionalTransition match {
        case Some(transition) => Some(transition execute())
        case None => None
      }
    }
  }

  /**
   * * PER CONVENTION THIS METHOD MUST BE CALLED ONLY AFTER 'nonSignaledTransition' (per state)
   * @param signal
   * @return
   */
  def signaledTransition(signal: Event.Event): Option[State] = {
    nextSignalTransition(signal) match {
      case Some(transition) => Some(transition execute())
      case None => None
    }
  }
}
