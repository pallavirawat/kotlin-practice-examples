// Complete the birthdayCakeCandles function below.
fun birthdayCakeCandles(ar: Array<Int>): Int {
    val max = ar.max()
    val let = max?.let {
        max ->
        ar.filter { it == max }
    }
    return let!!.size
}

fun main(args: Array<String>) {
    val ar = arrayOf(3,2,1,3)

    val result = birthdayCakeCandles(ar)

    println(result)
}
