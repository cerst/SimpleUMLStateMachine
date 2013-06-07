package org.una.simpleumlstatemachine.transition.impl.atm

import org.una.simpleumlstatemachine.transition.SignalTransition
import org.una.simpleumlstatemachine.state.State
import org.una.simpleumlstatemachine.state.impl.atm.Terminating
import org.una.simpleumlstatemachine.Event

/**
 * Created with IntelliJ IDEA.
 * User: cg
 * Date: 6/5/13
 * Time: 6:33 PM
 * To change this template use File | Settings | File Templates.
 */
class ToTerminating(private var t: Terminating) extends SignalTransition {
  def execute(): State = t

  def signal: Event.Event = Event.AtmDone
}
