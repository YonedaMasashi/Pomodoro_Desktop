package com.myone.pomodoro.domain

object EmStatus extends Enumeration { 
  type EmStatus = Value
  val idNonComplete = Value("未作業")
  val idComplete = Value("完了")
  val idWorking = Value("作業中")
}
