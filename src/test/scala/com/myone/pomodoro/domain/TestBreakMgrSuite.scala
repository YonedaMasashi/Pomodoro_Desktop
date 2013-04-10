package com.myone.pomodoro.domain
 
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import com.myone.pomodoro.domain._
import com.myone.pomodoro.infra._

class TestBreakMgrSuite extends FunSuite with BeforeAndAfter {

  var breakMgr:BreakMgr = _

  before { 
	breakMgr = new BreakMgr
  }

  test ("Two Break object add to BreakMgr") { 
	breakMgr.addBreak((TimeBox(TimePoint(0,10,13,120), TimePoint(0,35,13,120), Day(2013,4,8))))
	breakMgr.addBreak((TimeBox(TimePoint(0,10,13,120), TimePoint(0,35,13,120), Day(2013,4,9))))
	val resultBreak = breakMgr.getBreakHistory
	assert(resultBreak.size === 2)
  }
}
