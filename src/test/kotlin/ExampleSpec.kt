import Calculator.Calculator
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object CalculatorSpec: Spek({
    describe("A calculator") {
        val calculator by memoized { Calculator() }

        describe("addition") {
            it("returns the sum of its arguments") {
                val add = calculator.add(1, 2)
                assertThat(add).isEqualTo(3)
            }
        }
    }
})