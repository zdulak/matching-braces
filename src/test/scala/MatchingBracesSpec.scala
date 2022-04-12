import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class MatchingBracesSpec extends AnyFlatSpec with should.Matchers {
  behavior of "The areBracesMatched method"

  it should "return true for matching braces" in {
    MatchingBraces.areBracesMatched("[{()()}][]") shouldBe true
  }

  it should "return false for not matching braces" in {
    MatchingBraces.areBracesMatched("([)]") shouldBe false
  }

  it should "return false for not equal number of opening and closing braces" in {
    MatchingBraces.areBracesMatched("[{()}") shouldBe false
  }
}
