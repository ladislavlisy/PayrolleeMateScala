package Core

/**
 * Created by ladislavlisy on 28.10.15.
 */
case class SymbolName(code:Int, name:String) {
  def compareTo(other: SymbolName): Int = {
    code - other.code
  }
  def ==(other: SymbolName): Boolean = {
    code == other.code
  }
  def >(other: SymbolName): Boolean = {
    code > other.code
  }
  def <(other: SymbolName): Boolean = {
    code < other.code
  }
  def >=(other: SymbolName): Boolean = {
    !(this < other)
  }
  def <=(other: SymbolName): Boolean = {
    !(this > other)
  }
  def description: String = {
    s"$name" + "::" + s"$code"
  }

  override def toString:String = {
    s"$code"
  }
}
