package iv.zdo

fun solutionP1(s: String): Int {
    if(s.length==2){
        return s.toInt()
    }

    var maxSoFar = s.subSequence(0,2).toString().toInt()
    for (i in 2 until (s.length -1))
    {
        val curFragment = s.subSequence(i,i+2).toString().toInt()
        if(curFragment>maxSoFar)
            maxSoFar = curFragment
    }

    return maxSoFar;
}


fun main() {
    println(solutionP1("50552"))
    println(solutionP1("10101"))
    println(solutionP1("50559"))
    println(solutionP1("88"))
}