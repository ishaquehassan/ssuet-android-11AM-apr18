fun main(args: Array<String>) {
    var myRefFun:(Int)->Unit = fun (sum:Int){
        println("Hello world $sum")
    }

    var lambda:(Int)->Unit = {
        print("Sum is $it")
    }

    var lambdaWithMultiParam:(Int,Int)->Unit = {sum,extra ->
        print("Sum is $sum")
    }

    var lambdaWithReturnType:()->String = {
        println("")
        //return ""
        ""
    }

    calcTotal(arrayOf(1,2,3,4),fun (sum:Int){

    })
    //calcTotal(arrayOf(5,15),lambda)

    println(calculator("add")(2,3))
}


fun calculator(what:String):(Int,Int)->Int{
    val add:(Int,Int)->Int = {a,b ->a+b}
    val sub:(Int,Int)->Int = {a,b ->a-b}
    return when(what){
        "add" -> add
        "sub" -> sub
        else -> {a,b -> a*b}
    }
}

fun calcTotal(array:Array<Int>,callback:(Int)->Unit = {}){
    callback(array.sum())
}


