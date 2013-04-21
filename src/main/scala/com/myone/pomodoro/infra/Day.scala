package com.myone.pomodoro.infra

import java.util.Date

class Day (val year:Int, val month:Int, val day:Int) { 
  override def hashCode = (year + 17) * 17 + (month + 31) * 31 + day
  override def equals(other:Any) = other match { 
	case that: Day =>
	  (that canEqual this) && (this.year == that.year) && (this.month == that.month) && (this.day == that.day)
	case _ => false
  }
  
  // Day を継承した他のクラスのインスタンスでないかチェック
  def canEqual(other:Any) = other.isInstanceOf[Day]
  
}

object Day { 
  def apply(year:Int, month:Int, day:Int) = new Day(year, month, day)
  def apply(date:Date) = { 
	val strData = "%tY/%<tm/%<td/%<tH/%<tM/%<tS/%<tL" format date
    val listData = strData.split("/")
	val listDataInt = for (i <- listData) yield { i.toInt }
	new Day(listDataInt(0), listDataInt(2), listDataInt(3))
  }
}

