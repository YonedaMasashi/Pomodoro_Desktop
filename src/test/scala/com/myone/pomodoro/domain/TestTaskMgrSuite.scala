package com.myone.pomodoro.domain
 
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import com.myone.pomodoro.domain._
import com.myone.pomodoro.domain.EmStatus._
import com.myone.pomodoro.infra._

class TestTaskMgrSuite extends FunSuite with BeforeAndAfter {
  
  var taskMgr:TaskMgr = _
  
  before {
	taskMgr = new TaskMgr
	taskMgr.addTask("name1", Day(2013, 4, 10), 2, idNonComplete)
	taskMgr.addTask("name2", Day(2013, 5, 11), 3, idNonComplete)
  }

  test ("TaskMgr.findTaskFromTaskId dosen't find") { 
	val task = taskMgr.findTaskFromTaskId(4)
	assert(task === None)
  }

  test ("Add two Task to TaskMgr And Get All Task") { 
	val result = taskMgr.findTaskFromName(".*")
	result.foreach(a => println(a.taskInfo))
	assert(result.size === 2)
  }

  test ("Add two Task to TaskMgr And Get 1st Task From Name") { 
	val result = taskMgr.findTaskFromName("name1")
	result.foreach(a => println(a.taskInfo))
	assert(result.size === 1)
  }

  test ("Add two Task to TaskMgr And Get 2nd Task From TaskId") { 
	val result = taskMgr.findTaskFromTaskId(2)
	assert(result.get.taskInfo._1 === 2)
  }

  test ("Delete one Task from TaskMgr") { 
	taskMgr.addTask("name3", Day(2014, 6, 11), 4, idNonComplete)
	val result_before = taskMgr.findTaskFromName(".*")
	assert(result_before.size === 3)
	taskMgr.deleteTask(3)
	val result_after = taskMgr.findTaskFromName(".*")
	assert(result_after.size === 2)
  }
}
