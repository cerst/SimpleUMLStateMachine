package org.una.simpleumlstatemachine.transition

import org.una.simpleumlstatemachine.Event

/**
 * Created with IntelliJ IDEA.
 * User: cg
 * Date: 6/5/13
 * Time: 4:37 PM
 * To change this template use File | Settings | File Templates.
 */
trait SignalTransition extends Transition{

  def signal: Event.Event

}
