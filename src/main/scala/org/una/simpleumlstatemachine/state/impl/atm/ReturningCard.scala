package org.una.simpleumlstatemachine.state.impl.atm

import org.una.simpleumlstatemachine.state.blueprint.DefaultActualState

/**
 * Created with IntelliJ IDEA.
 * User: cg
 * Date: 6/5/13
 * Time: 7:50 PM
 * To change this template use File | Settings | File Templates.
 */
class ReturningCard extends DefaultActualState {
  def onDo() {}

  def onExit() {}

  def name: String = this.getClass.getSimpleName

  def onEntry() {}
}
