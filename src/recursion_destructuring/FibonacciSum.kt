package recursion_destructuring

fun fibonacciSum(totalNumToShow: Int, num1: Int = 1, num2: Int=1 ): Int {
    if(totalNumToShow == 0){
        return 0
    }
    println(num1)
    return num1 + fibonacciSum(totalNumToShow - 1, num2, num1 + num2)
}

tailrec fun fibonacciTailVersionSum(totalNumToShow: Int, num1: Int = 1, num2: Int = 1, fibonnacciSum: Int = 0): Int{
    if(totalNumToShow == 0){
        return fibonnacciSum
    }
    println("$num1")
    return fibonacciTailVersionSum(
        totalNumToShow - 1,
        num2,
        num1 + num2,
        fibonnacciSum + num1
    )
}

fun main() {
    val totalNumberToShow = 9
    println("_________________Finbonacci Head Recursion ______________________")
    println("sum is : ${fibonacciSum(totalNumberToShow)}")

    println("_________________Finbonacci Tail Recursion ______________________")
    println("sum is : ${fibonacciTailVersionSum(totalNumberToShow)}")

}