package org.una.simpleumlstatemachine.state.impl.atm

import org.una.simpleumlstatemachine.state.TerminatingState

/**
 * Created with IntelliJ IDEA.
 * User: cg
 * Date: 6/5/13
 * Time: 6:31 PM
 * To change this template use File | Settings | File Templates.
 */
class Terminating extends TerminatingState {
  def onExit() {
    println("ATM done")
  }
}
