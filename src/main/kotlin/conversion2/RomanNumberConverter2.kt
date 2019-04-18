package conversion2

import conversion2.RomanNumberConverter2.mapToInt
import conversion2.RomanNumberConverter2.replaceDescending

object RomanNumberConverter2 {
    fun convert(roman: String): Int {
        roman.validRomanNumber()
        return replaceDescending(roman)
            .map {
                mapToInt(it)
        }.sum()
    }

    fun mapToInt(it: Char): Int {
        return when (it) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> throw IllegalArgumentException("illegal character '$it' in roman number ")
        }
    }

    fun replaceDescending(roman: String): String {
        return roman
            .replace("IV", "IIII")
            .replace("IX", "VIIII")
            .replace("XL", "XXXX")
            .replace("XC", "LXXXX")
            .replace("CD", "CCCC")
            .replace("CM", "DCCCC")
    }

}

val validDescending = listOf("I","V","X","L","C","D","M")

private fun String.validRomanNumber() {
    if (this.matches(Regex(".*[IVXLCDM]{3}[IVXLCDM]+"))){
        throw IllegalArgumentException("$this is not a valid roman number")
    }
    val replaceDescending = replaceDescending(this)
    val sortedBy = replaceDescending.toList().sortedBy { -mapToInt(it) }.joinToString(separator="") {it.toString()}
    if(sortedBy != replaceDescending) {
        throw IllegalArgumentException("$this is not a valid roman number")
    }

}
