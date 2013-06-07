package org.una.simpleumlstatemachine

import scala.collection.immutable
import org.una.simpleumlstatemachine.state._
import scala.util.control.Breaks._

/**
 * Created with IntelliJ IDEA.
 * User: cg
 * Date: 6/5/13
 * Time: 2:56 PM
 * To change this template use File | Settings | File Templates.
 */
class StateLineProcessor(val predecessors: immutable.Set[StateLineProcessor], private var state: State) extends Thread {

  override def run() {
    println(Thread.currentThread().getName + " is starting")
    BlockingEventPool register()
    awaitPredecessorTermination()

    breakable {
      while (true) {
        // Handle state behavior
        state match {
          case s: InitialState => ; // Do nothing
          case s: EnteringState =>
            s onEntry()
          case s: ExitingState =>
            s onExit()
          case s: TerminatingState =>
            BlockingEventPool unregister()
            println(Thread.currentThread().getName + " has unregistered and terminates")
            break()
          case s: ActualState =>
            s onEntry()
            s onDo()
            s onExit()
        }
        // At this point the state must have been a continuing one
        // Now advance to next state
        state = state.asInstanceOf[ContinuingState].nonSignaledTransition() match {
          case Some(resState) => resState
          case None => processNextSignal()
        }
      }
    }
  }

  /**
   * Gets next signal and checks if the current state has a transition requiring that signal.
   * If so the state yield by executing that transition is returned.
   * Else recursively calls itself.
   * @return
   */
  private def processNextSignal(): State = {
    val nextSignal = BlockingEventPool awaitNext()
    state.asInstanceOf[ContinuingState].signaledTransition(nextSignal) match {
      case Some(state) => state
      case None => processNextSignal()
    }
  }

  private def awaitPredecessorTermination() = for (pre <- predecessors) {
    pre join()
  }
}
