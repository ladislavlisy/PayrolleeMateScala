package PayrolleeMate.Periods

/**
 * Created by ladislavlisy on 15/09/15.
 */
case class SeqOfYears(milestones: Array[SpanOfYears]) {
  def this(years: Array[Int]) {
    this(SeqOfYears.initFromArray(years))
  }

  def yearsIntervalForPeriod(period: MonthPeriod): SpanOfYears = {
    val spanForPeriod = milestones.filter((span) => SeqOfYears.selectForPeriod(span, period))
    spanForPeriod.last
  }

  def yearsIntervalList: Array[SpanOfYears] = {
    milestones.clone()
  }
}

object SeqOfYears {
  val END_YEAR_ARRAY: Int = 2100
  val END_YEAR_INTER: Int = 2099

  def transformZeroToUpto(year: Int) : Int = {
    if (year == 0) SeqOfYears.END_YEAR_ARRAY else year
  }
  def transformYearsToSpan(yearFrom: Int, yearUpto: Int) : SpanOfYears = {
    val tranUpto = SeqOfYears.transformZeroToUpto(yearUpto)
    val spanUpto = if (tranUpto == yearFrom) tranUpto else (tranUpto - 1)
    SpanOfYears(yearFrom, spanUpto)
  }
  def selectForPeriod(span: SpanOfYears, period: MonthPeriod): Boolean = {
    period.year >= span.yearFrom && period.year <= span.yearUpto
  }
  def initFromArray(years: Array[Int]): Array[SpanOfYears] = {
    val sortedYears = years.sortBy(SeqOfYears.transformZeroToUpto)
    val beginsBound = Math.max(0, sortedYears.length - 1)
    val beginsYears = sortedYears.slice(0, beginsBound)
    val finishBound = Math.max(0, sortedYears.length)
    val finishYears = sortedYears.slice(1, finishBound)
    val sortedZiped = beginsYears.zip(finishYears)
    sortedZiped.map((x) => SeqOfYears.transformYearsToSpan(x._1, x._2))
  }
}