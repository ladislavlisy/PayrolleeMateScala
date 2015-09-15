package PayrolleeMate.Periods

/**
 * Created by lisy on 14.9.15.
 */
case class SpanOfYears(yearFrom:Int, yearUpto:Int) {

  def compareTo(other: SpanOfYears): Int = {
    if (yearFrom == other.yearFrom) {
      return yearUpto.compareTo(other.yearUpto)
    }
    yearFrom.compareTo(other.yearFrom)
  }
  def ==(other: SpanOfYears): Boolean = {
    yearFrom == other.yearFrom && yearUpto == other.yearUpto
  }
  def >(other: SpanOfYears): Boolean = {
    if (yearFrom == other.yearFrom) {
      return yearUpto > other.yearUpto
    }
    yearFrom > other.yearFrom
  }
  def <(other: SpanOfYears): Boolean = {
    if (yearFrom == other.yearFrom) {
      return yearUpto < other.yearUpto
    }
    yearFrom < other.yearFrom
  }
  def >=(other: SpanOfYears): Boolean = {
    !(this < other)
  }
  def <=(other: SpanOfYears): Boolean = {
    !(this > other)
  }
  def className: String = {
    if (yearFrom == yearUpto) {
      return s"$yearFrom"
    }
    s"$yearFrom" + "to" + s"$yearUpto"
  }

  override def toString:String = {
    className
  }
}

object SpanOfYears {
  def CreateFromYear(year:Int): SpanOfYears = {
    SpanOfYears(year, year)
  }

  def CreateFromYearToYear(from:Int, upto:Int):SpanOfYears =  {
    SpanOfYears(from, upto)
  }

}