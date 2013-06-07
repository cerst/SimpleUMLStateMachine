package org.una.simpleumlstatemachine.state.blueprint

import org.una.simpleumlstatemachine.state.{State, InitialState}
import org.una.simpleumlstatemachine.transition.{CompletionTransition, Transition}

/**
 * Created with IntelliJ IDEA.
 * User: cg
 * Date: 6/7/13
 * Time: 7:38 AM
 * To change this template use File | Settings | File Templates.
 */
trait DefaultInitialState extends InitialState{

  private var ct: Option[CompletionTransition] = None

  def setCompletionTransition(ct: CompletionTransition) = {
    this.ct = Some(ct)
  }

  def nextCompletionTransition(): Option[Transition] = ct
}
