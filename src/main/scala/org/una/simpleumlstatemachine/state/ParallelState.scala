package org.una.simpleumlstatemachine.state

import org.una.simpleumlstatemachine.continuation.CompletionContinuation

/**
 * Subclasses of this trait are utilities to realize parallel behavior. Therefore they are supposed to only have a single completion continuation.
 */
trait ParallelState extends PseudoState with CompletionContinuation {

}
