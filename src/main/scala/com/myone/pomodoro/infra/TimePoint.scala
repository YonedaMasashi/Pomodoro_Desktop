package com.myone.pomodoro.infra

import java.util.Date

class TimePoint (val hour:Int, val minute:Int, val second:Int, val minSecond:Int) { 
  override def hashCode = (hour + 11) * 11 + (minute + 17) * 17 + second + minSecond
  override def equals(other:Any) = other match { 
	case that: TimePoint =>
	  (that canEqual this) && (this.hour == that.hour) && 
      (this.minute == that.minute) && (this.second == that.second) && 
      (this.minSecond == that.minSecond)
	case _ => false
  }
  def canEqual(other:Any) = other.isInstanceOf[TimePoint]

}

object TimePoint { 
  def apply(h:Int, m:Int, s:Int, min:Int) = new TimePoint(h, m, s, min)
  def apply(date:Date) = { 
	val strData = "%tY/%<tm/%<td/%<tH/%<tM/%<tS/%<tL" format date
    val listData = strData.split("/")
	val listDataInt = for (i <- listData) yield { i.toInt }
	new TimePoint(listDataInt(3), listDataInt(4), listDataInt(5), listDataInt(6))
  }

}
