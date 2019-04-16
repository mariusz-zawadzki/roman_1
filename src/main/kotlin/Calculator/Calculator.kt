package Calculator

class Calculator {
    var additions: Int = 0

    fun add(a: Int, b: Int): Int {
        additions++
        println(this)
        return a + b
    }

}
