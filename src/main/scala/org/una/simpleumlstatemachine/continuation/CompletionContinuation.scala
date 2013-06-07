package org.una.simpleumlstatemachine.continuation

import org.una.simpleumlstatemachine.transition.Transition

/**
 * Created with IntelliJ IDEA.
 * User: cg
 * Date: 6/7/13
 * Time: 7:17 AM
 * To change this template use File | Settings | File Templates.
 */
trait CompletionContinuation {

  def nextCompletionTransition(): Option[Transition]

}
