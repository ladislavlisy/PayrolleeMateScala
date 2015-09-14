package PayrolleMate.Periods

/**
 * Created by lisy on 14.9.15.
 */
case class SpanOfMonths(periodFrom:MonthPeriod, periodUpto:MonthPeriod) {
  def compareTo(other: SpanOfMonths): Int = {
    if (periodFrom == other.periodFrom) {
      return periodUpto.compareTo(other.periodUpto)
    }
    periodFrom.compareTo(other.periodFrom)
  }
  def ==(other: SpanOfMonths): Boolean = {
    periodFrom == other.periodFrom && periodUpto == other.periodUpto
  }
  def >(other: SpanOfMonths): Boolean = {
    if (periodFrom == other.periodFrom) {
      return periodUpto > other.periodUpto
    }
    periodFrom > other.periodFrom
  }
  def <(other: SpanOfMonths): Boolean = {
    if (periodFrom == other.periodFrom) {
      return periodUpto < other.periodUpto
    }
    periodFrom < other.periodFrom
  }
  def >=(other: SpanOfMonths): Boolean = {
    !(this < other)
  }
  def <=(other: SpanOfMonths): Boolean = {
    !(this > other)
  }
  def className: String = {
    if (periodFrom == periodUpto) {
      return "${periodFrom}"
    }
    "${periodFrom}to${periodUpto}"
  }

  override def toString:String = {
    className
  }

}

object SpanOfMonths {
  def CreateFromYear(year:Int): SpanOfMonths = {
    SpanOfMonths(MonthPeriod.beginYear(year), MonthPeriod.endYear(year))
  }

  def CreateFromMonth(period:MonthPeriod):SpanOfMonths = {
    SpanOfMonths(period, period)
  }

}