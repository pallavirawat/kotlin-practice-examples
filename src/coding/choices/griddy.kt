package coding.choices

import java.util.*


data class Coordinate(val x: Int, val y: Int){
    operator fun plus(operation: Coordinate): Coordinate {
        return Coordinate(this.x+ operation.x, this.y + operation.y)
    }

}

fun main() {

    val frogPossibleSteps = listOf(
        Coordinate(-1, 2), Coordinate(1, 2), Coordinate(1, -2), Coordinate(-1, -2),
        Coordinate(-1, -2), Coordinate(2, 0), Coordinate(-2, 0)
    )
    val insectCoordinate = Coordinate(0, 2)
    val frogCoordinate = Coordinate(6, 6)


    // f-i (y) %2 ==0
    //

    //5, 4,




    //DFS
//    println(checkPossibility(frogPossibleSteps, insectCoordinate, frogCoordinate))

    val matrix = Matrix(7)
    println(matrix.recursive(frogPossibleSteps, insectCoordinate, frogCoordinate))
}


private fun checkPossibility(frogPossibleStep: List<Coordinate>, insectCoordinate: Coordinate, frogCoordinate: Coordinate): Boolean {
    val stack = Stack<Pair<Coordinate, Coordinate>>()
    frogPossibleStep.forEach { stack.push(frogCoordinate to it) }


    while (stack.isNotEmpty()) {
        val parentCoordinateAndStep = stack.pop()
        val newFrogCoordinates = parentCoordinateAndStep.first + parentCoordinateAndStep.second

        if(isValid(newFrogCoordinates, 7)){
            if(newFrogCoordinates==insectCoordinate){
                return true;
            }
            else
            {
                frogPossibleStep.forEach { stack.push(newFrogCoordinates to it) }
            }

        }

    }
    return false
}


class Matrix(val size: Int){
    private val mp = hashMapOf<Coordinate, Boolean>()
    val frogPossibleSteps = listOf(
        Coordinate(-1, 2), Coordinate(1, 2), Coordinate(1, -2), Coordinate(-1, -2),
        Coordinate(-1, -2), Coordinate(2, 0), Coordinate(-2, 0)
    )


    fun recursive(frogPossibleSteps: List<Coordinate>, insectCoordinate: Coordinate, frogCoordinate: Coordinate): Boolean {
        if(mp.containsValue(true)) return true
        if(!isValid(frogCoordinate, this.size)){
            return false
        }else{
            if(frogCoordinate==insectCoordinate){
                mp[frogCoordinate] = true
                return true
            }
        }
        if (mp.containsKey(frogCoordinate)) {
            return mp[frogCoordinate]!!
        }

        var currentStepPOs = false
        for (frogStep in frogPossibleSteps){
            val newFrogCoordinates = frogCoordinate + frogStep
//            if(mp.containsKey(newFrogCoordinates)){
//                return mp[newFrogCoordinates]!!
//            }
            val containsPossiblePath = recursive(frogPossibleSteps, insectCoordinate, newFrogCoordinates)
//            mp[newFrogCoordinates] = containsPossiblePath
            currentStepPOs = currentStepPOs || containsPossiblePath
        }
        mp[frogCoordinate] = currentStepPOs

        return mp.containsValue(true)
    }

}

fun isValid(coordinate: Coordinate, matrixSize: Int): Boolean {
    return coordinate.x in 0 until matrixSize && coordinate.y in 0 until matrixSize

}