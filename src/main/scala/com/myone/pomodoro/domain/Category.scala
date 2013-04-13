package com.myone.pomodoro.domain

import scala.collection.mutable._

class Category(var name:String) { 
  private var _childCategories:ListBuffer[Category] = ListBuffer[Category]()

  def addChildCategory(chgChildCategory:Category):Unit = {
	_childCategories += chgChildCategory
  }

  def deleteChildCategory(childName:String):Boolean = { 
	val beforeSize = _childCategories.size
	_childCategories = _childCategories.filterNot(_.isMatchCategory(childName))
	(beforeSize - 1) == _childCategories.size

  }

  def childCategories:List[Category] = _childCategories.result

  def isMatchCategory(regStr:String):Boolean = { 
	val reg = regStr.r
	this.name match { 
	  case reg() => true
	  case _ => false
	}
  }
}

object Category { 
  def apply (n:String):Category = new Category(n)
}
