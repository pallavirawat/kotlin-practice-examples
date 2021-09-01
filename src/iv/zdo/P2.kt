package iv.zdo

import java.util.*

class P2 {
}
fun solution2(s: String): Int {
    // wri
    // te your code in Kotlin 1.3.11 (Linux)
    val occList = mutableMapOf<Char, Int>()

    for (c in s){
        if(occList.containsKey(c)){
            occList[c] = occList[c]!!.plus(1)
        }
        else
            occList[c] = 1
    }

    var charToBeDeleted = 0


    val trackerSet = TreeSet<Int>()

    for (occ in occList.values){
        if(!trackerSet.contains(occ)){
            trackerSet.add(occ)
        }
        else{
            var newOcc = occ-1
            while (newOcc>0 && trackerSet.contains(newOcc)){
                newOcc--
            }
            if(!trackerSet.contains(newOcc)){
                trackerSet.add(newOcc)
            }
            charToBeDeleted+=occ-newOcc
        }
    }

    return charToBeDeleted
}


fun main() {
    println(solution2("aaaabbbb"))
    println(solution2("ccaaffddecee"))
    println(solution2("eeee"))
    println(solution2("example"))
}