package org.una.simpleumlstatemachine

import scala.collection.mutable

/**
 * Created with IntelliJ IDEA.
 * User: cg
 * Date: 6/5/13
 * Time: 2:58 PM
 * To change this template use File | Settings | File Templates.
 */
object BlockingEventPool {

  private var callsToWaitFor = 0
  private var currentlyWaiting = 0
  private val guard: AnyRef = new AnyRef
  private val events = new mutable.Queue[Event.Event]
  private var currentEvent: Event.Event = _

  def add(e: Event.Event) {
    events synchronized {
      events enqueue e
      if (events.size == 1)
        events notifyAll
    }
  }

  def awaitNext(): Event.Event = {
    guard synchronized {
      currentlyWaiting += 1
      if (currentlyWaiting < callsToWaitFor)
        guard wait
      else events synchronized {
        if (events isEmpty)
          events wait()
        currentEvent = events dequeue()
        currentlyWaiting = 0
        guard notifyAll()

      }
    }
    currentEvent
  }

  def register() {
    guard synchronized {
      callsToWaitFor += 1
    }
  }

  def unregister() {
    guard synchronized {
      callsToWaitFor -= 1
    }
  }


}
