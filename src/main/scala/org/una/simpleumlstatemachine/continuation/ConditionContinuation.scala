package org.una.simpleumlstatemachine.continuation

import org.una.simpleumlstatemachine.transition.Transition

/**
 * Created with IntelliJ IDEA.
 * User: cg
 * Date: 6/7/13
 * Time: 7:19 AM
 * To change this template use File | Settings | File Templates.
 */
trait ConditionContinuation {

  /**
   * Conditions are supposed to be evaluated internally
   * @return
   */
  def nextConditionTransition(): Option[Transition]

}
