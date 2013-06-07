package org.una.simpleumlstatemachine.state.impl.givingMoney

import org.una.simpleumlstatemachine.state.InitialState

/**
 * Created with IntelliJ IDEA.
 * User: cg
 * Date: 6/5/13
 * Time: 7:54 PM
 * To change this template use File | Settings | File Templates.
 */
class Initial extends InitialState {
  def onEntry() {
    println("GivingMoney started")
  }
}
