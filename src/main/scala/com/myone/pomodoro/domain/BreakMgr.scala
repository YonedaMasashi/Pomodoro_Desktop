package com.myone.pomodoro.domain

import scala.collection.mutable._

class BreakMgr { 

  private val _breakHistory:ListBuffer[TimeBox] = ListBuffer[TimeBox]()

  def addBreak(addBrk:TimeBox): Unit = _breakHistory += addBrk
  def breakHistory:List[TimeBox] = _breakHistory.result
  
}
