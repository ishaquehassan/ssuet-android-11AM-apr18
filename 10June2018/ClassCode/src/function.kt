
fun letMePrint()
{
    println("hello world function")

    for (i in 0..5){
        println("loop $i")
    }
}
fun letMePrintWithUnit() : Unit{
    println("hello")

}

fun getString() : String{

    return "hello world"
}

fun main(args: Array<String>) {


    var value = getString()
    println(value)


}