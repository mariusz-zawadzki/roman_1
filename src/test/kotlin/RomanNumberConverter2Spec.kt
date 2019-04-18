import conversion2.RomanNumberConverter2
import org.assertj.core.api.Assertions
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.math.exp

object RomanNumberConverter2Spec : Spek({

    describe("converts simple numbers") {
        val numbers = listOf(
            Pair("I",1),
            Pair("II",2),
            Pair("III",3),
            Pair("V",5),
            Pair("X",10),
            Pair("L",50),
            Pair("C",100),
            Pair("D",500),
            Pair("M",1000)
            )

        numbers.forEach { (roman, expected) ->
            it("convets $roman to $expected") {
                Assertions.assertThat(RomanNumberConverter2.convert(roman)).isEqualTo(expected)
            }
        }
    }
})