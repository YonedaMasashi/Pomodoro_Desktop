package com.myone.pomodoro.domain

class Category(private var name:String) { 
  private var childCategory:Category = null

  def changeCategoryName(chgName:String) = { this.name = chgName }
  def getCategoryName : String = this.name

  def setChildCategory(childCategory:Category) = { 
	this.childCategory = childCategory
  }
}
