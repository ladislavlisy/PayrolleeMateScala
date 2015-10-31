package PayrolleeMate.Core

/**
 * Created by lisy on 14.9.15.
 */

import Core.SymbolName
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import org.scalatest.Assertions
import org.scalatest.junit.JUnitRunner

/**
 * Requires ScalaTest and JUnit4.
 */
@RunWith(classOf[JUnitRunner])
class TestSymbolName extends FunSuite with BeforeAndAfter {

  val testSymbolCode1001 = 1001
  val testSymbolCode2001 = 2001
  val testSymbolCode3001 = 3001
  val testSymbolCode4001 = 4001
  val testSymbolCode5001 = 5001

  before {
  }

  test("Should_Compare_Different_Symbols_AsEqual") {
    val testSymbolOne = SymbolName(testSymbolCode1001, "Begining Symbol")
    val testSymbolTwo = SymbolName(testSymbolCode1001, "Terminal Symbol")

    assert(testSymbolOne == testSymbolTwo)
  }

  test("Should_Compare_Different_Symbols_AsGreater") {
    val testPeriodOne = SymbolName(testSymbolCode1001, "Begining Symbol")
    val testPeriodTwo = SymbolName(testSymbolCode5001, "Terminal Symbol")

    assert(testPeriodOne != testPeriodTwo)
    assert(testPeriodTwo > testPeriodOne)
  }

  test("Should_Compare_Different_Symbols_AsLess") {
    val testPeriodOne = SymbolName(testSymbolCode1001, "Begining Symbol")
    val testPeriodTwo = SymbolName(testSymbolCode5001, "Terminal Symbol")

    assert(testPeriodOne != testPeriodTwo)
    assert(testPeriodOne < testPeriodTwo)
  }

}
  
