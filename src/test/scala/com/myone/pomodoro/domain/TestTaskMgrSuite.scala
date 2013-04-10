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

  test ("TaskMgr.getTaskFromTaskId dosen't find") { 
	val task = taskMgr.getTaskFromTaskId(4)
	assert(task === None)
  }

  test ("Add two Task to TaskMgr And Get All Task") { 
	val result = taskMgr.getTaskFromName(".*")
	result.foreach(a => println(a.getTaskInfo))
	assert(result.size === 2)
  }

  test ("Add two Task to TaskMgr And Get 1st Task From Name") { 
	val result = taskMgr.getTaskFromName("name1")
	result.foreach(a => println(a.getTaskInfo))
	assert(result.size === 1)
  }

  test ("Add two Task to TaskMgr And Get 2nd Task From TaskId") { 
	val result = taskMgr.getTaskFromTaskId(2)
	assert(result.get.getTaskInfo._1 === 2)
  }

  test ("Delete one Task from TaskMgr") { 
	taskMgr.addTask("name3", Day(2014, 6, 11), 4, idNonComplete)
	val result_before = taskMgr.getTaskFromName(".*")
	assert(result_before.size === 3)
	taskMgr.deleteTask(3)
	val result_after = taskMgr.getTaskFromName(".*")
	assert(result_after.size === 2)
  }
}
