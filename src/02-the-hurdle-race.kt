import kotlin.math.abs

// Complete the hurdleRace function below.
fun hurdleRace(k: Int, height: Array<Int>): Int {
    val max = height.max()
    if(k>=max!!){
        return k;
    }
    val doses = max?.let {
        max - k
    }
    return doses!!
}


fun main(args: Array<String>) {
    val ar = arrayOf(3,2,1,3)

    val result = birthdayCakeCandles(ar)

    println(result)
}