fun main(args: Array<String>) {

    printThis()
    println(sum(2,3))
    println(sum2(4))
    println(sum2(4,6))

    println(sum2(b = 2, a = 4))
}


fun printThis(){
    println("hello")
}

fun sum(a:Int,b:Int):Int{

    return a+b
}
fun sum2(a:Int,b:Int = 3):Int{

    return a+b
}
