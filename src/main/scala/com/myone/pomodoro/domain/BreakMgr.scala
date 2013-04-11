package com.myone.pomodoro.domain

import scala.collection.mutable._

class BreakMgr { 

  private val breakHistory:ListBuffer[TimeBox] = ListBuffer[TimeBox]()

  def addBreak(addBrk:TimeBox): Unit = breakHistory += addBrk
  def getBreakHistory:List[TimeBox] = return breakHistory.result
  
}
