package org.una.simpleumlstatemachine.transition

/**
 * Created with IntelliJ IDEA.
 * User: cg
 * Date: 6/5/13
 * Time: 4:33 PM
 * To change this template use File | Settings | File Templates.
 */
trait ConditionTransition extends Transition{

  def executable(): Boolean

}
