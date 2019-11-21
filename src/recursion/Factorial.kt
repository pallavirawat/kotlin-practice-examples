package recursion

fun main() {
    val number = 3
    println("_________________Factorial Head Recursion ______________________")
    println("$number! is: ${factorialOf(number)}")

    println("_________________Factorial Tail Recursion ______________________")
    println("$number! is: ${tailFactorialOf(number)}")

}

fun factorialOf(number: Int): Int {
    if(number == 1){
        return 1
    }
    return number * factorialOf(number - 1)
}


tailrec fun tailFactorialOf(number: Int, goVal : Int = 1) : Int {
    if(number ==1){
        return goVal
    }
    return tailFactorialOf(number -1 , goVal * number)
}
