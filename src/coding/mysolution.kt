package coding

//fun getMin(s: String): Int {
//    // Write your code here
//    val stack = Stack<Char>();
//    var count = 0
//    for(c in s){
//        if(stack.isEmpty()) {
//            if(c==')'){
//                count++
//            }
//            else{
//                stack.push(c)
//            }
//        }
//        else{
//            if(c==')'){
//                stack.pop()
//            }
//            else
//                stack.push(c)
//        }
//    }
//
//    stack.size
//
//
//    return count + stack.size
//}
//
//fun main(args: Array<String>) {
//    val s = "()))))))))))))))))))))))()()))()))))))))()))))))()))()))))(()))))))))))))()))))))(()))))))))()()))))))))))))()))))(())()))))))(()))))()))))))()))()())))())))))))))))()))())(()()())()()())))))()))))())()))()))))))))))))))()())))()))))()))))))()))())()))())))(()))()))))))))())))())))(())()))))()((()))))))((((()())())())(())))))())())))))))())))))()(()))))()))))())))))()())())()))()))))))))()))))))))))()))))())))))(((()))))()))((())))())))))))())))()()())())))))())))())())))))(())())))))))())))()()))))))))))))(())())())))((()))))))(())))()())))()))))(())))(())))))))))))))(())))(())()))))(()))())())))))))()())(()(())())))))))))))))))))))))))((()())))())))())))((()())))()))())()))))())()())))))))))))(()))))))))))))))()))))))()))))))))))))))))(()(()))(()))()))))))()))()()))))))))))()))())()))))())))()()()))()))))(())))))))))))))()()))))(())))()))))))()))()())()))())()())())))()()(()())))))()())))))))())))())))(())))())))))))()))))))))()((()(())))))))))(())))())))())))))))))()())))()))))))))("
//
//    val result = getMin(s)
//
//    println(result)
//}

fun getConnectedNo(a: String, b: String): String {

    val conversionMap = hashMapOf<Char, Char>()

    var count=0
    for(i in b.indices){
        if(a[i]==b[i]){
            continue
        }
        if(!conversionMap.contains(a[i])){
            conversionMap[a[i]] = b[i]
            count++
        }
        else
        {
            if(conversionMap[a[i]]!=b[i]){
                return "IMP"
            }
//            else count++
        }
    }

    return ""+count;

}

fun getCOnnectedNo(a: String, b: String): String{
    val convertedMap = hashMapOf<Char, Char>()

    var count = 0
    for(i in b.indices){
        if(a[i]==b[i]){
            continue
        }
        if(!convertedMap.containsKey(a[i])){
            convertedMap[a[i]] = b[i]
            count++
        }else{
            if(convertedMap[a[i]]!=b[i]){
                return "Impossible"
            }
        }
    }
    return ""+count

}

fun main(args: Array<String>) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
//    val s = readLine()!!
    val s = "26449 79119"
    val split = s.split(' ')


    val result = getConnectedNo(split[0], split[1])

    val result2 = getCOnnectedNo(split[0], split[1])

    println(result)
    println(result2)
}
