package periods

import java.time.format.DateTimeFormatter
import java.time.{DayOfWeek, YearMonth, LocalDate}
import java.util.Locale

/**
 * Created by lisy on 14.9.15.
 */
case class MonthPeriod(code:Int) {
  def year():Int = {
    code / 100
  }

  def month():Int = {
    code % 100
  }

  def yearInt():Int = {
    code / 100
  }

  def monthInt():Int = {
    code % 100
  }

  def monthOrder():Int = {
    Math.max(0, yearInt() - 2000) * 12 + monthInt()
  }

  def daysInMonth():Int = {
    YearMonth.of(yearInt, monthInt).lengthOfMonth
  }
  def beginOfMonth(): LocalDate = {
    LocalDate.of(yearInt, monthInt, 1)
  }

  def endOfMonth(): LocalDate = {
    LocalDate.of(yearInt, monthInt, daysInMonth)
  }

  def dateOfMonth(dayOrdinal:Int): LocalDate = {
    val periodDay: Int = Math.min(Math.max(1, dayOrdinal), daysInMonth)

    return LocalDate.of(yearInt, monthInt, periodDay)
  }

  def weekDayOfMonth(dayOrdinal:Int):Int = {
    val periodDate: LocalDate = dateOfMonth(dayOrdinal)

    val periodDateCwd: DayOfWeek = periodDate.getDayOfWeek

    return MonthPeriod.dayOfWeekMonToSun(periodDateCwd)
  }


  def description():String = {
    val firstPeriodDay: LocalDate = beginOfMonth
    val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH)
    firstPeriodDay.format(dateFormatter)
  }

  def compareTo(other:MonthPeriod):Int = {
    code.compareTo(other.code)
  }

  def isEqualToPeriod(other:MonthPeriod): Boolean = {
    code == other.code
  }

  def ==(other: MonthPeriod): Boolean = {
    code == other.code
  }
  def !=(other: MonthPeriod): Boolean = {
    code != other.code
  }
  def < (other: MonthPeriod): Boolean = {
    code < other.code
  }
  def > (other: MonthPeriod): Boolean = {
    code > other.code
  }
  def <=(other: MonthPeriod): Boolean = {
    code <= other.code
  }
  def >=(other: MonthPeriod): Boolean = {
    code >= other.code
  }

  override def toString():String = {
    Integer.toString(this.code)
  }
}

object MonthPeriod {
  val PRESENT:Int = 0
  val TERM_BEG_FINISHED:Int = 32
  val TERM_END_FINISHED:Int = 0

  def dayOfWeekMonToSun(periodDateCwd: DayOfWeek):Int = {
    periodDateCwd.getValue
  }
}