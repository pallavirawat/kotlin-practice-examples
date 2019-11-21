class Header

fun extendHeaderAndMess(myBuilder: Header.()-> Unit){
    val header: Header = Header()
    myBuilder(header)
    header.myBuilder()
}

class Config {
    var word = ""
    operator fun invoke(s: String): Config {
        word += s
        return this
    }
}

class Config2{
    var count=0
}

operator fun Config2.invoke(i: Int): Config2{
    count+=i;
    return this
}


fun main() {
    extendHeaderAndMess {
        println("hello")
    }
    val config = Config()
    config("R")("o")("b")("e")("r")("t")
    val invoke = config.invoke("s")
    val invoke2 = invoke.invoke("s")
    println(invoke.toString())
    println(invoke2.toString())
    println(config.word)
    val config2 = Config2()
    val config21 = config2(2)(3)(4)
    println(config21.count)
}