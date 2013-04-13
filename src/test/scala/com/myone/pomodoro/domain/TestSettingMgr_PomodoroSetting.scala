package com.myone.pomodoro.domain
 
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import com.myone.pomodoro.domain._
import com.myone.pomodoro.domain.EmStatus._
import com.myone.pomodoro.infra._

class TestSettingMgr_PomodoroSetting extends FunSuite with BeforeAndAfter {
  
  var settingMgr:SettingMgr = _

  before { 
	settingMgr = new SettingMgr
  }

  test ("Get Pomodoro Setting Time") { 
	assert (settingMgr.pomodoroSetting.pomodoroInterval == 25)
	assert (settingMgr.pomodoroSetting.breakInterval == 5)
  }

  test ("Change Pomodoro Setting Time") { 
	settingMgr.pomodoroSetting.pomodoroInterval = 20
	settingMgr.pomodoroSetting.breakInterval = 3
	assert (settingMgr.pomodoroSetting.pomodoroInterval == 20)
	assert (settingMgr.pomodoroSetting.breakInterval == 3)
  }
  
}
