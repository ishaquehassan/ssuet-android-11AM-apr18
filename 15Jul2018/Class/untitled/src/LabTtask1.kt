fun adder(num:Int):()->Int{
    var inc = 0
    return fun ():Int{
        inc += num
        return inc
    }
}

fun main(args: Array<String>) {
    val adder1 = adder(2)
    val adder2 = adder(10)
    println("Adder 1 ${adder1()}")
    println("Adder 1 ${adder1()}")
    println("Adder 2 ${adder2()}")
    println("Adder 2 ${adder2()}")
}