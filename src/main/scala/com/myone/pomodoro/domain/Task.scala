package com.myone.pomodoro.domain

import scala.collection.mutable._

import com.myone.pomodoro.domain.EmStatus._
import com.myone.pomodoro.infra.Day

class Task (private var taskId:Int, private var name:String, private var deadline:Day, private var estimate:Int, private var status:EmStatus) { 

  private var category:Category = _
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

  def setCategory(updCategory:Category): Unit = { 
	this.category = updCategory
  }

  def getTaskInfo : (Int, String, Day, Int, EmStatus, Category) = { 
	return (this.taskId, this.name, this.deadline, this.estimate, this.status, this.category)
  }

  def addTimeBox(timeBox:TimeBox) = { 
	this.pomodoroHistory += timeBox
  }

  def getPomodoroHistory : List[TimeBox] = this.pomodoroHistory.result

  def isMatchName(name:String) : Boolean = { 
	val r = name.r
	this.name match { 
	  case r() => true
	  case _ => false
	}
  }

  def isMatchTaskId(taskId:Int) : Boolean = { 
	this.taskId == taskId
  }

}
