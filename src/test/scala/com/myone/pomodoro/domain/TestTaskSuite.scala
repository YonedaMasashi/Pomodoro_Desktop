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
	task = new Task(1, "Hoge", Day(2013,4,10), 2, idNonComplete, null)
  }
  
  test ("Task クラスの値の変更をテスト") { 
	task.changeName("Piyo")
	task.changeDeadline(Day(2013,5,1))
	task.changeEstimate(5)
	task.changeStatus(idComplete)

	val taskInfo = task.getTaskInfo
	assert (taskInfo._2 === "Piyo")	
	assert (taskInfo._3 === Day(2013,5,1))	
	assert (taskInfo._4 === 5)	
	assert (taskInfo._5 === idComplete)	
  }

  test ("Task のカテゴリ設定") { 
	val tmpCat = Category("ParentCat")
	tmpCat.setChildCategory(Category("ChildCat"))
	task.setCategory(tmpCat)
	val taskInfo = task.getTaskInfo
	assert (taskInfo._6.getCategoryName === "ParentCat")
	assert (taskInfo._6.getChildCategory.getCategoryName === "ChildCat")
  }

  test ("Task のタイムボックス設定") { 
	task.addTimeBox(TimeBox(TimePoint(0,10,13,120), TimePoint(0,35,13,120), Day(2013,4,8)))
	task.addTimeBox(TimeBox(TimePoint(0,12,14,122), TimePoint(0,37,14,122), Day(2013,4,9)))
	task.addTimeBox(TimeBox(TimePoint(1,11,15,140), TimePoint(1,36,15,140), Day(2013,4,10)))
	val history = task.getPomodoroHistory
	assert (history.size === 3)
  }
}

