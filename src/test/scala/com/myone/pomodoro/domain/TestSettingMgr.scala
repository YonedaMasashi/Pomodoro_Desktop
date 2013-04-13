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
	val result = settingMgr.categoryList
	assert (result.size == 1)
	val firstElem = result.head
	assert (firstElem.name === "Hoge")
  }

  test ("Find Category from Category Name") { 
	settingMgr.addCategory(Category("Hoge2"))
	val result = settingMgr.findCategory("Hoge2")
	assert (result.size != 0)
	result.foreach(t => assert(t.name === "Hoge2"))
  }

  test ("Not Find Category from Category Name") { 
	settingMgr.addCategory(Category("Hoge2"))
	val result = settingMgr.findCategory("Hoge3")
	assert (result.size === 0)
  }
  
  test ("Delete Category from Category Name") { 
	settingMgr.addCategory(Category("Piyo1"))
	settingMgr.addCategory(Category("Piyo2"))
	settingMgr.addCategory(Category("Piyo3"))
	val result = settingMgr.deleteCategory("Piyo3")
	assert (result === true)
	val value = settingMgr.categoryList
	assert (value.size === 2)
  } 

  test ("Delete Category But Not Find Category") { 
	settingMgr.addCategory(Category("Piyo1"))
	settingMgr.addCategory(Category("Piyo2"))
	settingMgr.addCategory(Category("Piyo3"))
	assert (settingMgr.deleteCategory("Piyo4") == false)
	val value = settingMgr.categoryList
	assert (value.size === 3)
  } 

  test ("Delete Child Category To SettingMgr") { 
	val cat1 = Category("Parent1")
	cat1.addChildCategory(Category("Child1"))
	cat1.addChildCategory(Category("Child2"))
	cat1.addChildCategory(Category("Child3"))
	val cat2 = Category("Parent2")

	settingMgr.addCategory(cat1)
	settingMgr.addCategory(cat2)

	val foundList = settingMgr.findCategory("Parent1")
	assert (foundList.size === 1)
	assert (foundList.head.childCategories.size === 3)
	assert (foundList.head.deleteChildCategory("Child2") == true)
	assert (foundList.head.childCategories.size === 2)
  }
}
