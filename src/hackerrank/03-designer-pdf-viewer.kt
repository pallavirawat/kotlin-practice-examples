package hackerrank

// Complete the hackerearth.designerPdfViewer function below.
fun designerPdfViewer(h: Array<Int>, word: String): Int {
    val map = word.map {
        h[it.toInt() - 97]
    }
    return map.max()!! * map.size
}

fun main(args: Array<String>) {
    val ar = arrayOf(3,2,1,3)

    val result = designerPdfViewer(ar, "abc")

    println(result)
}