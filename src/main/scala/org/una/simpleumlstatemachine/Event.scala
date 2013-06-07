package org.una.simpleumlstatemachine

/**
 * Created with IntelliJ IDEA.
 * User: cg
 * Date: 6/5/13
 * Time: 3:04 PM
 * To change this template use File | Settings | File Templates.
 */
object Event extends Enumeration {
  type Event = Value
  val CardEntered, PinEntered, BankDone, AtmDone = Value

}
