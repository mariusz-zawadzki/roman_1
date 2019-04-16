import conversion.RomanNumberConverter
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object RomanNumberConverterSpec : Spek({

    val romanToArabic by memoized { RomanNumberConverter() }
    group("Simple roman numbers") {
        describe("are converted") {
            it(" I is 1"){
                assertThat(romanToArabic.toArabic("I")).isEqualTo(1)
            }

            it("II is 2") {
                assertThat(romanToArabic.toArabic("II")).isEqualTo(2)
            }
            it("III is 3") {
                assertThat(romanToArabic.toArabic("III")).isEqualTo(3)
            }
            it("IV is 4") {
                assertThat(romanToArabic.toArabic("IV")).isEqualTo(4)
            }
            it("V is 5") {
                assertThat(romanToArabic.toArabic("V")).isEqualTo(5)
            }

            it("X is 10") {
                assertThat(romanToArabic.toArabic("X")).isEqualTo(10)
            }
            it("IX is 9") {
                assertThat(romanToArabic.toArabic("IX")).isEqualTo(9)
            }
            it("XXX is 30") {
                assertThat(romanToArabic.toArabic("XXX")).isEqualTo(30)
            }
            it("XL is 40") {
                assertThat(romanToArabic.toArabic("XL")).isEqualTo(40)
            }
            it("L is 50") {
                assertThat(romanToArabic.toArabic("L")).isEqualTo(50)
            }
            it("C is 100") {
                assertThat(romanToArabic.toArabic("C")).isEqualTo(100)
            }
            it("M is 1000") {
                assertThat(romanToArabic.toArabic("M")).isEqualTo(1000)
            }
            it("LXXXX is 90") {
                assertThat(romanToArabic.toArabic("LXXXX")).isEqualTo(90)
            }
            it("MCMLXXXXIX is 1999") {
                assertThat(romanToArabic.toArabic("MCMLXXXXIX")).isEqualTo(1999)
            }
            it("MMXIX is 2019") {
                assertThat(romanToArabic.toArabic("MMXIX")).isEqualTo(2019)
            }
        }
    }
})