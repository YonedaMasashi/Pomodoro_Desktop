package com.myone.pomodoro.domain

import scala.collection.mutable._

import com.myone.pomodoro.domain.EmStatus._
import com.myone.pomodoro.infra.Day

class Task (private var taskId:Int, var name:String, var deadline:Day, var estimate:Int, var status:EmStatus) { 

  var parentCategory:Category = _
  var childCategory:Category = _
  private val _pomodoroHistory:ListBuffer[TimeBox] = ListBuffer[TimeBox]()

  def taskInfo : (Int, String, Day, Int, EmStatus, Category, Category) = { 
	return (this.taskId, this.name, this.deadline, this.estimate, this.status, parentCategory, childCategory)
  }

  def addTimeBox(timeBox:TimeBox):Unit = { 
	_pomodoroHistory += timeBox
  }

  def pomodoroHistory: List[TimeBox] = _pomodoroHistory.result

  def isMatchName(name:String): Boolean = { 
	val r = name.r
	this.name match { 
	  case r() => true
	  case _ => false
	}
  }

  def isMatchTaskId(taskId:Int): Boolean = { 
	this.taskId == taskId
  }

}
