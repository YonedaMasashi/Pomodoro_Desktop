package com.myone.pomodoro.domain

/* example
import org.scalatest.FunSuite
class TestSuite extends FunSuite {
  test("test suite") {
    assert(1 === 1, "test")
  }
}
*/

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import com.myone.pomodoro.domain.EmStatus._
import com.myone.pomodoro.domain._
import com.myone.pomodoro.infra._

class TestTaskSuite extends FunSuite with BeforeAndAfter {

  var task: Task = _
  
  before { 
	task = new Task(1, "Hoge", Day(2013,4,10), 2, idNonComplete)
  }
  
  test ("Modify Task Object Value") { 
	task.name = "Piyo"
	task.deadline = Day(2013,5,1)
	task.estimate = 5
	task.status = idComplete

	val taskInfo = task.taskInfo
	assert (taskInfo._2 === "Piyo")	
	assert (taskInfo._3 === Day(2013,5,1))	
	assert (taskInfo._4 === 5)	
	assert (taskInfo._5 === idComplete)	
  }

  test ("Set Category To Task Object") { 
	val tmpCat = Category("ParentCat")
	tmpCat.addChildCategory(Category("ChildCat"))
	task.parentCategory = tmpCat
	task.childCategory = tmpCat.childCategories.head
	val taskInfo = task.taskInfo
	assert (taskInfo._6.name === "ParentCat")
	assert (taskInfo._7.name === "ChildCat")
  }

  test ("Add three PomodoroTimeBox To Task Object") { 
	task.addTimeBox(TimeBox(TimePoint(0,10,13,120), TimePoint(0,35,13,120), Day(2013,4,8)))
	task.addTimeBox(TimeBox(TimePoint(0,12,14,122), TimePoint(0,37,14,122), Day(2013,4,9)))
	task.addTimeBox(TimeBox(TimePoint(1,11,15,140), TimePoint(1,36,15,140), Day(2013,4,10)))
	val history = task.pomodoroHistory
	assert (history.size === 3)
  }
}


