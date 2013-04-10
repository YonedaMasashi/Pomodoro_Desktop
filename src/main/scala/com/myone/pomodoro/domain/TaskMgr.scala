package com.myone.pomodoro.domain

import scala.collection.mutable._

import com.myone.pomodoro.domain.EmStatus._
import com.myone.pomodoro.infra.Day

class TaskMgr { 
  private var nextTaskId:Int = 1
  private var taskList:Map[Int, Task] = Map[Int, Task]()
  
  def deleteTask(taskId:Int) = { taskList.remove(taskId) }

  def getTaskFromTaskId(taskId:Int): Option[Task] = { taskList.get(taskId) }

  def getTaskFromName(name:String): List[Task] = { 
	taskList.filter(t => t._2.isMatchName(name)).values.toList
  }

  def addTask (name:String, deadline:Day, estimate:Int, status:EmStatus) = { 
	var task = new Task(nextTaskId, name, deadline, estimate, status)
	taskList += nextTaskId -> task
	nextTaskId += 1
  }
}
