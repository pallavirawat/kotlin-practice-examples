package others

import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter

class Dog {
    private val noise : String = "Woof"
    fun makeNoise(){
        println(" I am a dog! $noise $noise")
    }

    private fun makeNoiseQuietly(){
        println("Shhhhh! $noise $noise")
    }
}

class ReflectionA(val p: Int)

fun main() {
    val dog = Dog()
    dog::class.java.getDeclaredField("noise").apply { isAccessible = true }.set(dog, "Owwwwww")
    dog.makeNoise()

    dog::class.java.getDeclaredMethod("makeNoiseQuietly").apply { isAccessible = true }.invoke(dog)

    val javaGetter = ReflectionA::p.javaGetter
    println(javaGetter) // prints "public final int others.A.getP()"
    println(ReflectionA::p.javaField)  // prints "private final int others.A.p"
}