package com.myone.pomodoro.infra

import scala.actors._
import scala.actors.Actor._

class IntervalTimerActor (val interval_sec:Int, val who:Actor, val reply:Any) extends Actor { 
  def act { 
	loop {
	  reactWithin(interval_sec) { 
		case TIMEOUT =>
		  who ! reply
		case "end" =>
		  exit
	  }
	}
  }
}
