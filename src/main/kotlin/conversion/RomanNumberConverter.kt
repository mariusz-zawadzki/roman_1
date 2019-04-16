package conversion

import java.lang.IllegalStateException

class RomanNumberConverter {

    val literals = listOf(
        "M" to 1000,
        "CM" to 900,
        "C" to 100,
        "L" to 50,
        "XL" to 40,
        "X" to 10,
        "IX" to 9,
        "V" to 5,
        "IV" to 4,
        "I" to 1
    )

    fun toArabic(s: String):Int {
        var stringLeft = s;
        var sum = 0;
        while(stringLeft.length > 0)
        {
            val find = literals.find { literal ->
                stringLeft.startsWith(literal.first)
            } ?: throw IllegalStateException("Could not find any literals in '$stringLeft'")
            sum+=find.second
            stringLeft = stringLeft.substring(find.first.length)

        }
        return sum
    }

}
