package com.myone.pomodoro.domain

import scala.collection.mutable._

object SettingMgr { 
  private var _categoryList:ListBuffer[Category] = ListBuffer[Category]()
  val pomodoroSetting: PomodoroSetting = PomodoroSetting(25, 5)
  
  def addCategory(category:Category):Unit = _categoryList += category

  def categoryList:List[Category] = _categoryList.result

  def findCategory(regParentName:String): List[Category] = { 
	_categoryList.filter(_.isMatchCategory(regParentName)).result
  }

  def deleteCategory(categoryName:String):Boolean = { 
	val beforeSize = _categoryList.size
	_categoryList = _categoryList.filterNot(_.isMatchCategory(categoryName))
	(beforeSize - 1) == _categoryList.size
  }

  def clearCategory = { 
	_categoryList.clear
  }

}
