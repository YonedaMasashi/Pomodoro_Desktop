package com.myone.pomodoro.domain

class Category(private var name:String) { 
  private var childCategory:Category = null

  def changeCategoryName(chgName:String):Unit = { this.name = chgName }
  def getCategoryName : String = this.name

  def setChildCategory(childCategory:Category):Unit = { this.childCategory = childCategory }
  def getChildCategory:Category = this.childCategory
}

object Category { 
  def apply (n:String):Category = new Category(n)
}
