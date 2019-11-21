val prime = sequence {
    var numbers = generateSequence(2) { it + 1 }
    //generates a sequence of number 2,3,4,5,6,7,8,9........

//    var prime:Int
    while (true){
//        println("${numbers.toList()}") //not possible as numbers is an infinite list
//        prime = numbers.first()
        val prime = numbers.first()
        println("gonna yield $prime")
        yield(prime)
        val dropCustom = numbers.dropCustom(1, prime)
        numbers = dropCustom.filter {
            println("inside filter for number $it for prime check of no $prime")
            it%prime!=0
        }
    }

}
fun <T> Sequence<T>.dropCustom(n: Int, prime: Int): Sequence<T> {
    println("dropping $prime")
    return this.drop(n)
}

fun main() {
    println(prime.take(6).toList())

//    var numbers = generateSequence(1) { it + 1 }
//    numbers = numbers.dropCustom(1,1).filter {
//            println("inside filter for number $it")
//            true
//    }
//    numbers = numbers.dropCustom(1,2).filter {
//        println("inside filter 2 for number $it")
//        true
//    }
//    print(numbers.take(4).toList())
}