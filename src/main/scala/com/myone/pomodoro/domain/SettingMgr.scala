package com.myone.pomodoro.domain

import scala.collection.mutable._

class SettingMgr { 
  private var categoryList:ListBuffer[Category] = ListBuffer[Category]()
  
  def addCategory(category:Category):Unit = this.categoryList += category

  def getAllCategorys:List[Category] = categoryList.result

  def findCategory(name:String): Option[Category] = { 
	val result = categoryList.filter(_.getCategoryName == name)
	result.isEmpty match { 
	  case true => None
	  case _ => Some(result.head)
	}
  }
}

  
