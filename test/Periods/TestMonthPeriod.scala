package PayrolleMate.Periods

/**
 * Created by lisy on 14.9.15.
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
  class TestMonthPeriod extends FunSuite with BeforeAndAfter {

    val testPeriodCodeJan = 201401
    val testPeriodCodeFeb = 201402
    val testPeriodCode501 = 201501
    val testPeriodCode402 = 201402

    before {
    }

    test("Should_Compare_Different_Periods_AsEqual_When_2014_01") {
      val testPeriodOne = MonthPeriod(testPeriodCodeJan)
      val testPeriodTwo = MonthPeriod(testPeriodCodeJan)
  
      assert(testPeriodOne == testPeriodTwo)
    }
  
    test("Should_Compare_Different_Periods_AsEqual_When_2014_02") {
      val testPeriodOne = MonthPeriod(testPeriodCodeFeb)
      val testPeriodTwo = MonthPeriod(testPeriodCodeFeb)
  
      assert(testPeriodOne == testPeriodTwo)
    }
  
    test("Should_Compare_Different_Periods_SameYear_AsGreater") {
      val testPeriodOne = MonthPeriod(testPeriodCodeJan)
      val testPeriodTwo = MonthPeriod(testPeriodCodeFeb)
  
      assert(testPeriodOne != testPeriodTwo)
      assert(testPeriodTwo > testPeriodOne)
    }
  
    test("Should_Compare_Different_Periods_SameYear_AsLess") {
      val testPeriodOne = MonthPeriod(testPeriodCodeJan)
      val testPeriodTwo = MonthPeriod(testPeriodCodeFeb)
  
      assert(testPeriodOne != testPeriodTwo)
      assert(testPeriodOne < testPeriodTwo)
    }
  
    test("Should_Compare_Different_Periods_SameMonth_AsGreater") {
      val testPeriodOne = MonthPeriod(testPeriodCodeJan)
      val testPeriodTwo = MonthPeriod(testPeriodCode501)
  
      assert(testPeriodOne != testPeriodTwo)
      assert(testPeriodTwo > testPeriodOne)
    }
  
    test("Should_Compare_Different_Periods_SameMonth_AsLess") {
      val testPeriodOne = MonthPeriod(testPeriodCodeJan)
      val testPeriodTwo = MonthPeriod(testPeriodCode501)
  
      assert(testPeriodOne != testPeriodTwo)
      assert(testPeriodOne < testPeriodTwo)
    }
  
    test("Should_Compare_Different_Periods_DifferentYear_AsGreater") {
      val testPeriodOne = MonthPeriod(testPeriodCode402)
      val testPeriodTwo = MonthPeriod(testPeriodCode501)
  
      assert(testPeriodOne != testPeriodTwo)
      assert(testPeriodTwo > testPeriodOne)
    }
  
    test("Should_Compare_Different_Periods_DifferentYear_AsLess") {
      val testPeriodOne = MonthPeriod(testPeriodCode402)
      val testPeriodTwo = MonthPeriod(testPeriodCode501)
  
      assert(testPeriodOne != testPeriodTwo)
      assert(testPeriodOne < testPeriodTwo)
    }
  
    test("Should_Return_Periods_Year_And_Month_2014_01") {
      val testPeriodOne = MonthPeriod(testPeriodCodeJan)
  
      assert(2014 == testPeriodOne.year    )
      assert(   1 == testPeriodOne.month   )
      assert(2014 == testPeriodOne.yearInt )
      assert(   1 == testPeriodOne.monthInt)
    }
  
    test("Should_Return_Periods_Year_And_Month_2014_02") {
      val testPeriodOne = MonthPeriod(testPeriodCodeFeb)
  
      assert(2014 == testPeriodOne.year    )
      assert(   2 == testPeriodOne.month   )
      assert(2014 == testPeriodOne.yearInt )
      assert(   2 == testPeriodOne.monthInt)
    }
  
    test("Should_Return_Periods_Month_And_Year_Description") {
      val testPeriodJan = MonthPeriod(testPeriodCodeJan)
      val testPeriodFeb = MonthPeriod(testPeriodCodeFeb)
      val testPeriod501 = MonthPeriod(testPeriodCode501)
      val testPeriod402 = MonthPeriod(testPeriodCode402)
  
      assert("January 2014" == testPeriodJan.description)
      assert("February 2014"== testPeriodFeb.description)
      assert("January 2015" == testPeriod501.description)
      assert("February 2014"== testPeriod402.description)
    }
}
