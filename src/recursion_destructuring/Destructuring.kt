package recursion_destructuring

class Hello(private val v1: String, private val v2: String) {
    operator fun component1(): String {
        return v1
    }

    operator fun component2(): String {
        return v2
    }
}

fun main() {
    val (a, b) = Hello("hello", "blah")
    print("$a and $b")
}