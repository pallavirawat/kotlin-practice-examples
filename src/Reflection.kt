class Dog {
    private val noise : String = "Woof"
    fun makeNoise(){
        println(" I am a dog! $noise $noise")
    }

    private fun makeNoiseQuietly(){
        println("Shhhhh! $noise $noise")
    }
}

fun main() {
    val dog = Dog()
    dog::class.java.
            getDeclaredField("noise").apply { isAccessible = true }.set(dog, "Owwwwww")
    dog.makeNoise()

    dog::class.java.getDeclaredMethod("makeNoiseQuietly").apply { isAccessible = true }.invoke(dog)
}