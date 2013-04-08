package com.myone.pomodoro.domain

import com.myone.pomodoro.infra.TimePoint
import com.myone.pomodoro.infra.Day

class TimeBox (val startTime:TimePoint, val endTime:TimePoint, val startDay:Day) {

  def saveStartTime (updStartTime:TimePoint): TimeBox = { 
	TimeBox(updStartTime, this.endTime, this.startDay)
  }
  def saveEndTime (updEndTime:TimePoint): TimeBox = { 
	TimeBox(this.startTime, updEndTime, this.startDay)
  }
}

object TimeBox { 
  def apply(startTime:TimePoint, endTime:TimePoint, startDay:Day) = new TimeBox(startTime, endTime, startDay)
}

