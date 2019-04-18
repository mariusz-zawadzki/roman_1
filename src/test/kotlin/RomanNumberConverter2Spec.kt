import conversion2.RomanNumberConverter2
import org.assertj.core.api.Assertions
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.lang.IllegalArgumentException
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

    describe("converts properly ascending letters") {
        val numbers = listOf(
            Pair("IV",4),
            Pair("IX",9),
            Pair("XL",40),
            Pair("XC",90),
            Pair("CD",400),
            Pair("CM",900)
        )

        numbers.forEach { (roman, expected) ->
            it("convets $roman to $expected") {
                Assertions.assertThat(RomanNumberConverter2.convert(roman)).isEqualTo(expected)
            }
        }
    }

    describe("does not convert an invalid string") {
        val numbers = listOf(
            "IIII",
            "VVVV",
            "XXXX",
            "LLLL",
            "CCCC",
            "DDDD",
            "MMMM",
            "VL",
            "IL",
            "IM"
        )

        numbers.forEach { roman ->
            it("does not convert $roman ") {
                Assertions.assertThatThrownBy {
                    RomanNumberConverter2.convert(roman)
                }.isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessage("$roman is not a valid roman number")
            }
        }
    }
})