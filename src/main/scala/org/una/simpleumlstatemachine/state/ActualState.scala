package org.una.simpleumlstatemachine.state

import org.una.simpleumlstatemachine.action.{ExitAction, DoAction, EntryAction}
import org.una.simpleumlstatemachine.continuation.{SignalContinuation, ConditionContinuation, CompletionContinuation}

/**
 * Created with IntelliJ IDEA.
 * User: cg
 * Date: 6/5/13
 * Time: 2:46 PM
 * To change this template use File | Settings | File Templates.
 */
trait ActualState extends ContinuingState with EntryAction with DoAction with ExitAction with CompletionContinuation with ConditionContinuation with SignalContinuation {

  def name: String

}
