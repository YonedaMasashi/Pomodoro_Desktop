package com.myone.pomodoro.domain
 
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import com.myone.pomodoro.domain._
import com.myone.pomodoro.domain.EmStatus._
import com.myone.pomodoro.infra._

class TestSettingMgrSuite extends FunSuite with BeforeAndAfter {
  
  before { 
	SettingMgr.clearCategory
  }
  
  test ("Add Category To SettingMgr") { 
	SettingMgr.addCategory(Category("Hoge"))
	val result = SettingMgr.categoryList
	assert (result.size == 1)
	val firstElem = result.head
	assert (firstElem.name === "Hoge")
  }

  test ("Find Category from Category Name") { 
	SettingMgr.addCategory(Category("Hoge2"))
	val result = SettingMgr.findCategory("Hoge2")
	assert (result.size != 0)
	result.foreach(t => assert(t.name === "Hoge2"))
  }

  test ("Not Find Category from Category Name") { 
	SettingMgr.addCategory(Category("Hoge2"))
	val result = SettingMgr.findCategory("Hoge3")
	assert (result.size === 0)
  }
  
  test ("Delete Category from Category Name") { 
	SettingMgr.addCategory(Category("Piyo1"))
	SettingMgr.addCategory(Category("Piyo2"))
	SettingMgr.addCategory(Category("Piyo3"))
	val result = SettingMgr.deleteCategory("Piyo3")
	assert (result === true)
	val value = SettingMgr.categoryList
	assert (value.size === 2)
  } 

  test ("Delete Category But Not Find Category") { 
	SettingMgr.addCategory(Category("Piyo1"))
	SettingMgr.addCategory(Category("Piyo2"))
	SettingMgr.addCategory(Category("Piyo3"))
	assert (SettingMgr.deleteCategory("Piyo4") == false)
	val value = SettingMgr.categoryList
	assert (value.size === 3)
  } 

  test ("Delete Child Category To SettingMgr") { 
	val cat1 = Category("Parent1")
	cat1.addChildCategory(Category("Child1"))
	cat1.addChildCategory(Category("Child2"))
	cat1.addChildCategory(Category("Child3"))
	val cat2 = Category("Parent2")

	SettingMgr.addCategory(cat1)
	SettingMgr.addCategory(cat2)

	val foundList = SettingMgr.findCategory("Parent1")
	assert (foundList.size === 1)
	assert (foundList.head.childCategories.size === 3)
	assert (foundList.head.deleteChildCategory("Child2") == true)
	assert (foundList.head.childCategories.size === 2)
  }
}
