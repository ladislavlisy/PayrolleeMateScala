package PayrolleeMate.Periods

/**
 * Created by ladislavlisy on 15/09/15.
 */
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import org.scalatest.Assertions
import org.scalatest.junit.JUnitRunner

/**
 * Requires ScalaTest and JUnit4.
 */
@RunWith(classOf[JUnitRunner])
class TestSpanOfYears extends FunSuite with BeforeAndAfter {

  test("Should_Return_IntervalName_2013") {
    val testInterval: SpanOfYears = new SpanOfYears(2013, 2013)
    val testName: String = testInterval.className
    assert("2013" == testName)
  }

  test("Should_Return_IntervalName_2011to2013") {
    val testInterval: SpanOfYears = new SpanOfYears(2011, 2013)
    val testName: String = testInterval.className
    assert("2011to2013" == testName)
  }

  test("Should_Return_IntervalArray_2011_2015") {
//    val testChangeYears: Array[Int] = Array[Int](2011, 2012, 2014, 2016, 2017, 0)
//    val testYearArray: SeqOfYears = new SeqOfYears(testChangeYears)
//    val expIntervalArray: List[SpanOfYears] = List(
//      SpanOfYears(2011, 2011),
//      SpanOfYears(2012, 2013),
//      SpanOfYears(2014, 2015),
//      SpanOfYears(2016, 2016),
//      SpanOfYears(2017, 2099))
//    val testIntervalArray: List[SpanOfYears] = testYearArray.toYearsIntervalList
//    assert(expIntervalArray == testIntervalArray)
  }

  test("Should_Return_Interval_2011_For_Period_2011") {
//    val testChangeYears: Array[Int] = Array[Int](2011, 2012, 2014, 2016, 2017, 0)
//    val testYearArray: SeqOfYears = new SeqOfYears(testChangeYears)
//    val testPeriod: MonthPeriod = new MonthPeriod(2011, 1)
//    val expInterval: SpanOfYears = SpanOfYears(2011, 2011)
//    val testInterval: SpanOfYears = testYearArray.yearsIntervalForPeriod(testPeriod)
//    assert(expInterval == testInterval)
  }

  test("Should_Return_Interval_2016_For_Period_2016") {
//    val testChangeYears: Array[Int] = Array[Int](2011, 2012, 2014, 2016, 2017, 0)
//    val testYearArray: SeqOfYears = new SeqOfYears(testChangeYears)
//    val testPeriod: MonthPeriod = new MonthPeriod(2016, 1)
//    val expInterval: SpanOfYears = SpanOfYears(2016, 2016)
//    val testInterval: SpanOfYears = testYearArray.yearsIntervalForPeriod(testPeriod)
//    assert(expInterval == testInterval)
  }

  test("Should_Return_Interval_2012to2013_For_Period_2013") {
//    val testChangeYears: Array[Int] = Array[Int](2011, 2012, 2014, 2016, 2017, 0)
//    val testYearArray: SeqOfYears = new SeqOfYears(testChangeYears)
//    val testPeriod: MonthPeriod = new MonthPeriod(2013, 1)
//    val expInterval: SpanOfYears = SpanOfYears(2012, 2013)
//    val testInterval: SpanOfYears = testYearArray.yearsIntervalForPeriod(testPeriod)
//    assert(expInterval == testInterval)
  }

  test("Should_Return_Interval_2017to2099_For_Period_2018") {
//    val testChangeYears: Array[Int] = Array[Int](2011, 2012, 2014, 2016, 2017, 0)
//    val testYearArray: SeqOfYears = new SeqOfYears(testChangeYears)
//    val testPeriod: MonthPeriod = new MonthPeriod(2018, 1)
//    val expInterval: SpanOfYears = SpanOfYears(2017, 2099)
//    val testInterval: SpanOfYears = testYearArray.yearsIntervalForPeriod(testPeriod)
//    assert(expInterval == testInterval)
  }
}
