package hackerrank

import java.io.BufferedInputStream
import java.io.BufferedReader
import java.util.*

// Complete the sockMerchant function below.
fun sockMerchant(n: Int, ar: Array<Int>): Int {

    return 2

}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = sockMerchant(n, ar)

    println(result)
}
