data class Scoping(val v1: String, var v2: String)


fun main() {

    //++++++++++++++++++++++ LET ++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //returns the result of the lambda function
    val scoping: Scoping = Scoping("pallavi", "rawat")
    val scoping2: Scoping = Scoping("munmun", "wara")
    val valueLet = scoping.let { sobj ->
        //receives a lambda
        val a = "f"
        println("scoping print 1 $sobj")
        println("scoping print 2 $sobj")
        sobj.v1
    }

    //Equivalent to :
    println("scoping print 1 $scoping")
    println("scoping print 2 $scoping")
    val valueLet2 =  scoping.v1
    //Use case: You have an object you want to do some processing and then return the final result from that object


    //can also be used as a null check
    val s2 = listOf(scoping).firstOrNull()
    val valueLetNull = s2?.let {
        println("scoping print 1 $it")
        println("scoping print 2 $it")
        it.v1
    }

    //equivalent to:
    if(s2!=null){
        println("scoping print 1 $s2")
        println("scoping print 2 $s2")
    }
    val valueLetNull2 =  s2?.v1

    //++++++++++++++++++++++ WITH ++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //use case
    val valueWithAppended = with(scoping) {
        println("scoping print 1 $v1")
        println("scoping print 2 $v2")
        v1+v2
    }

    //equivalent to:
    println("scoping print 1 ${scoping.v1}")
    println("scoping print 2 ${scoping.v2}")
    val valueWithAppended2 = scoping.v1 + scoping.v2

    //consider in tests where you are putting up assertions on field
    //ex: val styleObject = Style(styleNo, id, name, code, variant, price)
    // with(styleObject){
    //  assertEquals(styleNo, "23AA")
    //  assertEquals(id, 23)
    //  assertEquals(name, 23)
    // }

    //++++++++++++++++++++++ RUN ++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //similar to let but the context object is available as this unlike lets it
    // acts as an extension function anonymous to the class object
    val valueRun = scoping.run {
        println("scoping print 1 $v1")
        println("scoping print 2 $v2")
        v1+v2
    }

    //can also be used to declare an anonymous function/ block of scoped code
    val scopingRun = run{
        val firstName = "Andrew" // hence these variables would not be exposed to the recursion.main scope and
        // has a short lived scope. Space saving???? Does that happen that gc collects it?
        val lastName = "andy"
        Scoping(firstName, lastName)
    }

    //++++++++++++++++++++++ APPLY ++++++++++++++++++++++++++++++++++++++++++++++++++++//
    // context is availabe as this and return type is always this
    //read as “apply the following assignments to the object.”
    val valueApply = scoping.apply {
        v2="let us change this now"
        v1 + v2 //this wont be returned
    }
    // can be used for complex processing over an object where you want to do additional things
    // but return the object itself at the end like some configuration to be done in an object

    //++++++++++++++++++++++ ALSO ++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //brother of apply as it also returns the object itself but the context is available as it
    val also = listOf(1, 2, 4).sorted().also { print(it) }
    //can be useful for logging purpose or debugging where you dont change the original list
    //also gets removed without breaking the chain


    // apply and run is useful when we want to do a couple of things in the object,
    // Context available readily as this. choose on the basis of what you want the return type to be

}