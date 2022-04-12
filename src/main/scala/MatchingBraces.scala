import scala.annotation.tailrec

object MatchingBraces {
  def areBracesMatched(str: String): Boolean = {
    val openingBraces = List('(', '[', '{')
    @tailrec
    def bracesHelper(currentStr: String, bracesStack: List[Char]): Boolean = {
      if (currentStr.isEmpty && bracesStack.isEmpty) true
      else if (currentStr.isEmpty && bracesStack.nonEmpty) false
//    Case when next char is opening brace
      else if (openingBraces.contains(currentStr.head)) bracesHelper(currentStr.tail, currentStr.head +: bracesStack)
//    Case when next char is closing brace
      else if (currentStr.head.opposite == bracesStack.head) bracesHelper(currentStr.tail, bracesStack.tail)
//    Case like ([)]
      else false
    }

    bracesHelper(str, List.empty[Char])
  }

  implicit class CharExtensions(val char: Char) {
    def opposite: Char = char match {
      case '(' => ')'
      case ')' => '('
      case '[' => ']'
      case ']' => '['
      case '{' => '}'
      case '}' => '{'
    }
  }
}
