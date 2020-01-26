package others

open class Parent {
    init {
        f()
    }

    open fun f() {
        println("In A f")
    }
}

class Child : Parent() {
    var x: Int = 0

    // With x = 0 it produces output as
    // Hello World!!
    //  x in f: 1
    //  x: 1
    //  x2: 1
    //  in main x : 1


    // With x=3 it produces output as
    // Hello World!!
    //  x in f: 1
    //  x: 3
    //  x2: 3
    //  in main x : 3


    // https://stackoverflow.com/questions/59822125/kotlin-variable-initialization-for-child-class-behaves-weird-for-initializing-va

    // Kotlin basically considers 0 as unitialised var value for primitives and doesn't initialise them at all. Why???
    // Converting it to var x: Int? = 0 basically solves this issue and kotlin does get initialised with the zero value
    // recommendation is thus avoiding usage of open members in base classes functions

    init {
        println("x: " + x)
    }

    override fun f() {
        x = 1
        println("x in f: " + x)
    }

    init {
        println("x2: " + x)
    }
}

fun main() {
    println("Hello World!!")
    val b = Child()
    println("in main x : " + b.x)
}