package hackerrank
fun gradingStudents(grades: Array<Int>): MutableList<Int> {
    val finalGrades = mutableListOf<Int>()
    grades.forEach {
        if(it<38){
            finalGrades.add(it)
        }
        else{
            if(it%5>2)
                finalGrades.add((it+(5-(it%5))))
            else
                finalGrades.add(it)
        }

    }
    return finalGrades

}


fun main(args: Array<String>) {
    val gradesCount = readLine()!!.trim().toInt()

    val grades = Array<Int>(gradesCount, { 0 })
    for (i in 0 until gradesCount) {
        val gradesItem = readLine()!!.trim().toInt()
        grades[i] = gradesItem
    }

    val result = gradingStudents(grades)

    println(result.joinToString("\n"))
}
