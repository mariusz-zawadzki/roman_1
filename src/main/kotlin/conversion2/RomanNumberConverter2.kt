package conversion2

import java.lang.IllegalArgumentException

object RomanNumberConverter2 {
    fun convert(roman: String): Int {
        return roman.map {
            when(it){
                'I' -> 1
                'V' -> 5
                'X' -> 10
                'L' -> 50
                'C' -> 100
                'D' -> 500
                'M' -> 1000
                else -> throw IllegalArgumentException("illegal character '$it' in roman number ")
            }
        }.sum()
    }

}
