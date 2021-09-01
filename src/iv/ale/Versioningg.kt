package iv.ale
//[
//
//3.2.1
//3.0
//3
//"3.0.0"
//"2.9.9"
//]
//
//input: 2.9.9 then all other should be printed
//
//
//max 2 decimals
//
//latestversion
//
//Version{
//    majorv
//    minorv=0
//    minorminorv=0
//    raw=""
//
//    fun compare(Version)
//
//}
//}
data class Version(val raw: String){
    private val majorVersion: Int = extractVersionAtLvl(raw, 1)
    private val minorVersion: Int = extractVersionAtLvl(raw, 2)
    private val minorminorVersion:Int = extractVersionAtLvl(raw, 3)

    fun isLaterTHan(inputVersion: Version): Boolean {
        return when {
            majorVersion>inputVersion.majorVersion -> true
            majorVersion==inputVersion.majorVersion -> {
                when {
                    minorVersion>inputVersion.minorVersion -> true
                    minorVersion==inputVersion.minorVersion -> {
                        minorminorVersion>inputVersion.minorminorVersion
                    }
                    else -> false
                }
            }
            else -> false
        }
    }
}

fun extractVersionAtLvl(raw: String, level: Int): Int {
    val versionParts = raw.split(".")
    if(level > versionParts.size ){
        return 0
    }
   return versionParts[level-1].toInt()
}

fun main() {
    val versionList = listOf("3.2.1", "3.0", "2.9.9", "2.8", "3.0.0", "3")
    val inputVersion = Version("3.2.1")

    for (version in versionList){
        val curVersion = Version(version)

        if(curVersion.isLaterTHan(inputVersion)){
            println(curVersion.raw)
        }
    }
}



