package org.una.simpleumlstatemachine.state.blueprint

import scala.collection.mutable
import org.una.simpleumlstatemachine.transition.{Transition, SignalTransition, ConditionTransition, CompletionTransition}
import org.una.simpleumlstatemachine.Event
import org.una.simpleumlstatemachine.state.ActualState

/**
 * Created with IntelliJ IDEA.
 * User: cg
 * Date: 6/7/13
 * Time: 7:25 AM
 * To change this template use File | Settings | File Templates.
 */
trait DefaultActualState extends ActualState {

  private var completionTransitions = new mutable.LinkedList[CompletionTransition]()
  private var conditionTransitions = new mutable.LinkedList[ConditionTransition]()
  private val signalTransitions = mutable.Map[Event.Event, SignalTransition]().empty

  def addCompletionTransition(c: CompletionTransition) = completionTransitions = completionTransitions :+ c

  def addConditionTransition(c: ConditionTransition) = conditionTransitions = conditionTransitions :+ c

  def addSignalTransition(s: SignalTransition) = signalTransitions update(s.signal, s)

  //TODO: bad impl but we only expect one of these transitions to be present (ATM) -> choice should be random
  def nextCompletionTransition(): Option[Transition] = completionTransitions.headOption

  //TODO: bad impl but we only expect one of these transitions to be present (ATM) -> choice should be random
  def nextConditionTransition(): Option[Transition] = conditionTransitions.headOption

  def nextSignalTransition(trigger: Event.Event): Option[Transition] = signalTransitions get trigger

}
