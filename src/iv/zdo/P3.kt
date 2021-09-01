package iv.zdo

class P3 {
}
fun solution(a: IntArray): Int {
    // write your code in Kotlin 1.3.11 (Linux)
    var cost = a[1] + a[3]

    if(a.size==5){
        return cost
    }

    for (i in 1 until (a.size-4)){
        for(j in i+2 until a.size-1){
            val curCost = a[i] + a[j]
            if(curCost< cost)
                cost= curCost
        }
    }

    return cost
}


fun main() {
    println(solution(arrayListOf(5,2,4,6,3,7).toIntArray()))
    println(solution(arrayListOf(5,2,1,4,6,3,7,2,4,5,5).toIntArray()))
}