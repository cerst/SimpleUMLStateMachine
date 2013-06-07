package org.una.simpleumlstatemachine.transition

import org.una.simpleumlstatemachine.state.State

/**
 * Created with IntelliJ IDEA.
 * User: cg
 * Date: 6/5/13
 * Time: 4:31 PM
 * To change this template use File | Settings | File Templates.
 */
trait Transition {

  def execute(): State

}
