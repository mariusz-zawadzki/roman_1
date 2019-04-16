import Calculator.Calculator
import org.assertj.core.api.Assertions
import org.spekframework.spek2.Spek
import org.spekframework.spek2.lifecycle.CachingMode
import org.spekframework.spek2.style.gherkin.Feature
import org.spekframework.spek2.style.specification.describe

object CalculatorSpec : Spek({

    Feature("A calculatpr") {
        val calculator by memoized { Calculator() }

        Scenario("addition") {

            var result = 0
            Given("Something") {

            }

            When("1 + 2") {
                result = calculator.add(1, 2)
            }

            Then(" = 3") {
                Assertions.assertThat(result).isEqualTo(3)
            }
        }
    }
    group("Statefull calculator that counts additions") {

        describe("A calculator") {
            val calculator by memoized(mode = CachingMode.SCOPE) { Calculator() }

            describe("addition for given numbers") {
                val numbers = listOf(
                    Triple(1, 2, 3),
                    Triple(4, 5, 9),
                    Triple(0, 1, 1)
                )

                numbers.forEach { (a, b, c) ->

                    it(" with $a + $b  = $c") {
                        val add = calculator.add(a, b)

                        Assertions.assertThat(add).isEqualTo(c)
                    }
                }

                it("Additions done") {
                    Assertions.assertThat(calculator.additions).isEqualTo(3)
                }
            }
        }
    }
})