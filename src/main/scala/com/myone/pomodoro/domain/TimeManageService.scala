package com.myone.pomodoro.domain


object EmBreakPomodoro extends Enumeration { 
  type EmBreakPomodoro = Value
  val idNoExec = Value("未作業")
  val idBreak = Value("休憩")
  val idPomodoro = Value("ポモドーロ")
}

import com.myone.pomodoro.domain.EmBreakPomodoro._
import com.myone.pomodoro.infra.Day
import com.myone.pomodoro.infra.TimePoint
import com.myone.pomodoro.infra.IntervalTimerActor
import java.util.Date
import scala.actors.Actor
import scala.actors.Actor._

class TimeManageService { 
  private var _currentExecTaskId:Int = _
  private var _emTimeMgrKind:EmBreakPomodoro = idNoExec
  private var _execTimeBox:TimeBox = _

  private var _timerActor:IntervalTimerActor = _
  private var _pomodoroActor:Actor = pomodoroExecute

  private def pomodoroExecute = actor {
//ToDo本当はこっち	val waitLimit = SettingMgr.pomodoroSetting.pomodoroInterval * 1000 * 60
	val waitLimit = SettingMgr.pomodoroSetting.pomodoroInterval * 1000
 	var count = 0
	loop { 
	  react { 
		case x =>
		  count += 1
		  println(x)
		  if (count > waitLimit) { 
			_timerActor ! "end"
		  }
	  }
	}
  }

  def currentExecTaskId:Int = _currentExecTaskId
  def emTimeMgrKind:EmBreakPomodoro = _emTimeMgrKind
  
  def startPomodoro(taskId:Int):Unit = { 
	_currentExecTaskId = taskId
	_emTimeMgrKind = idPomodoro

	val date = new Date
	val day = Day(date)
	val startTime = TimePoint(date)
	val tmpTime = TimePoint(1,1,1,1)
	_execTimeBox = TimeBox(startTime, tmpTime, day)
	_pomodoroActor.start
  }
}

