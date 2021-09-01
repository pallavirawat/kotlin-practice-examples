package iv.ale


// inputs: 2,3,5,7
// output: 105 70 42 30

fun main() {
    val list = listOf(2, 3, 5, 7)

    var acc = 1
    list.forEach {
        acc*=it
    }

    list.forEach {
        println(" " + acc/it)
    }

}

