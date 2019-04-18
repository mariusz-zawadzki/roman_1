package conversion

import java.lang.IllegalStateException

class RomanNumberConverter {

    val literals = listOf(
        "CM" to 900,
        "CD" to 400,

        "XC" to 90,
        "XL" to 40,

        "IX" to 9,
        "IV" to 4,

        "M" to 1000,
        "D" to 500,
        "C" to 100,
        "L" to 50,
        "X" to 10,
        "V" to 5,
        "I" to 1
    ).sortedBy { it.second }.reversed()

    fun toArabic(s: String):Int {
        var stringLeft = s;
        var sum = 0;
        while(stringLeft.isNotEmpty())
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
