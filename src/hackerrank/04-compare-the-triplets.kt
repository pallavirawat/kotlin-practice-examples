package hackerrank

// Complete the hackerearth.beautifulDays function below.

// Complete the hackerearth.compareTriplets function below.
fun compareTriplets(a: Array<Int>, b: Array<Int>): Array<Int> {
    var ac = 0
    var bc = 0
    for (i in 1..a.size)
    {
        if(a[i-1]>b[i-1])
            ac++
        else if (a[i-1]<b[i-1])
            bc++
    }
    return arrayOf(ac,bc)


}

fun main(args: Array<String>) {
    val a = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val b = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = compareTriplets(a, b)

    println(result.joinToString(" "))
}