import kotlin.math.abs

// Complete the beautifulDays function below.
fun beautifulDays(i: Int, j: Int, k: Int): Int {
    var count = 0;
    (i..j).toList().forEach {
        val diffI = abs(it - it.toString().reversed().toInt())
        if(diffI%k == 0)
            count++
    }
    return count
}


fun main(args: Array<String>) {
    val result = beautifulDays(20,23,6)

    println(result)
}