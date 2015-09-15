package PayrolleeMate.Periods

/**
 * Created by ladislavlisy on 15/09/15.
 */
case class SeqOfYears(milestones: List[Int]) {
  def this(years: Array[Int]) {
    this(years.sortBy(SeqOfYears.sortYear).toList)
  }

  def yearsIntervalForPeriod(period: MonthPeriod): SpanOfYears = {
    def forPeriodAccumulator(agr: SpanOfYears, x: Int): SpanOfYears = {
      val intYear = if (x == 0) SeqOfYears.END_YEAR_ARRAY else x
      val intFrom = if (period.year >= intYear) intYear else agr.yearFrom
      val intUpto = if (period.year < intYear && agr.yearUpto == 0) (intYear - 1) else agr.yearUpto

      SpanOfYears(intFrom, intUpto)
    }
    val initsSpan: SpanOfYears = SpanOfYears.CreateFromYear(0)
    val validSpan: SpanOfYears = milestones.foldLeft(initsSpan) (forPeriodAccumulator)
    validSpan
  }

  def toYearsIntervalList: List[SpanOfYears] = {
    def toListAccumulator(agr: List[SpanOfYears], x: Int): List[SpanOfYears] = {
      val firstPart = agr.takeWhile((y) => y.yearUpto != 0)

      if (agr.isEmpty) {
        firstPart ::: List(SpanOfYears(x, 0))
      } else {
        val lastPart = agr.takeRight(1).head

        if (x == 0) {
          val historyFrom = lastPart.yearFrom
          val historyUpto = SeqOfYears.END_YEAR_INTER

          firstPart ::: List(SpanOfYears(historyFrom, historyUpto))
        } else {
          val historyFrom = lastPart.yearFrom
          val historyUpto = Math.max(x - 1, historyFrom)

          firstPart ::: List(SpanOfYears(historyFrom, historyUpto), SpanOfYears(x, 0))
        }
      }
    }
    val history: List[SpanOfYears] = milestones.foldLeft(List[SpanOfYears]()) (toListAccumulator)
    val lastHistoryPart: SpanOfYears = history.takeRight(1).head
    if (lastHistoryPart.yearUpto == 0) {
      val firstHistoryPart: List[SpanOfYears] = history.takeWhile((y) => y.yearUpto != 0)
      val historyFrom: Int = lastHistoryPart.yearFrom
      val historyUpto: Int = lastHistoryPart.yearFrom
      return firstHistoryPart ::: List(SpanOfYears(historyFrom, historyUpto))
    }
    history
  }
}

object SeqOfYears {
  val END_YEAR_ARRAY: Int = 2100
  val END_YEAR_INTER: Int = 2099

  def sortYear(year: Int): Int = {
    if (year == 0) SeqOfYears.END_YEAR_ARRAY else year
  }
}