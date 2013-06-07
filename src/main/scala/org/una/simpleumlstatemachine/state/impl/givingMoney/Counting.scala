package org.una.simpleumlstatemachine.state.impl.givingMoney

import org.una.simpleumlstatemachine.state.blueprint.DefaultActualState

/**
 * Created with IntelliJ IDEA.
 * User: cg
 * Date: 6/5/13
 * Time: 7:55 PM
 * To change this template use File | Settings | File Templates.
 */
class Counting extends DefaultActualState {
  def onDo() {
    println("I DO DA COUNTING")
  }

  def onExit() {}

  def name: String = this.getClass.getSimpleName

  def onEntry() {}
}
