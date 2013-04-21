package com.myone.pomodoro.domain
 
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import com.myone.pomodoro.infra._
import scala.actors._
import scala.actors.Actor._

class TestOneSecIntervalTimerActorSuite extends FunSuite with BeforeAndAfter {

  var timerActor:IntervalTimerActor = _

  test ("1 sec Sleep") { 
	
	val a = actor { 
	  var count = 0
	  loop { 
		react { 
		  case x =>
			count += 1
			println(x)
		    if (count > 4) { 
			  timerActor ! "end"
			}
		}
	  }
	}
	timerActor = new IntervalTimerActor (1000, a, "go for it")
	a.start
	timerActor.start
	println("Sleep start")
	Thread.sleep(10000)
	
  }
}
