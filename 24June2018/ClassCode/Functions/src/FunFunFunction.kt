
fun printFunction(){
    println("printing value from function")
}

fun chaiWala1():String{

    return "tea is here"
}

fun funWithParam(sugar:Int ):String{

    return "tea is here with sugar level $sugar "
}
fun funWithParams(sugar:Int ,milkQty : Int):String{

    return "tea is here with sugar level $sugar , $milkQty"
}
fun funWithParamsWithDefault(sugar:Int = 2,milkQty : Int = 2):String{

    return "tea is here with sugar level $sugar , $milkQty"
}
fun funWithParamsWithSkip(sugar:Int = 2,milkQty : Int):String{

    return "tea is here with sugar level $sugar , $milkQty"
}

val myValFun:()->Unit = fun (){
    println("hello world")
}

fun main(args: Array<String>) {

    println(funWithParams(milkQty = 2, sugar = 3))

    myValFun




}