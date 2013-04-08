package com.myone.pomodoro.domain

import scala.collection.mutable._

import com.myone.pomodoro.domain.EmStatus._
import com.myone.pomodoro.infra.Day

class Task (private var taskId:Int, private var name:String, private var deadline:Day, private var estimate:Int, private var status:EmStatus, private var category:Category) { 

  private val pomodoroHistory:ListBuffer[TimeBox] = ListBuffer[TimeBox]()

  def changeName(updName:String):Unit = { 
	this.name = updName
  }

  def changeDeadline(updDeadline:Day): Unit = { 
	this.deadline = updDeadline
  }

  def changeEstimate(updEstimate:Int):Unit = { 
	this.estimate = updEstimate
  }
  
  def changeStatus(updStatus:EmStatus): Unit = { 
	this.status = updStatus
  }

  def getTaskInfo : (Int, String, Day, Int, EmStatus) = { 
	return (this.taskId, this.name, this.deadline, this.estimate, this.status)
  }

  def addTimeBox(timeBox:TimeBox) = { 
	this.pomodoroHistory += timeBox
  }
  
}
