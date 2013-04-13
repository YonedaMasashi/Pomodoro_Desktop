package com.myone.pomodoro.domain

class PomodoroSetting (var pomodoroInterval:Int, var breakInterval:Int) { 
}

object PomodoroSetting { 
  def apply (p:Int, b:Int): PomodoroSetting = new PomodoroSetting(p, b)
}
