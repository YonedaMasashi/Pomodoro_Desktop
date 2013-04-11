package com.myone.pomodoro.domain
 
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import com.myone.pomodoro.domain._
import com.myone.pomodoro.domain.EmStatus._
import com.myone.pomodoro.infra._

class TestSettingMgrSuite extends FunSuite with BeforeAndAfter {
  
  var settingMgr:SettingMgr = _

  before { 
	settingMgr = new SettingMgr
  }
  
  test ("Add Category To SettingMgr") { 
	settingMgr.addCategory(Category("Hoge"))
	val result = settingMgr.getAllCategorys
	assert (result.size == 1)
	val firstElem = result.head
	assert (firstElem.getCategoryName === "Hoge")
  }

  test ("Find Category from Category Name") { 
	settingMgr.addCategory(Category("Hoge2"))
	val result = settingMgr.findCategory("Hoge2")
	result match { 
	  case Some(cat) => assert (cat.getCategoryName == "Hoge2")
	  case _ => assert (false, "findCategory result is None")
	}
  }

  test ("Not Find Category from Category Name") { 
	settingMgr.addCategory(Category("Hoge2"))
	val result = settingMgr.findCategory("Hoge3")
	assert (result === None)
  }
  
}
