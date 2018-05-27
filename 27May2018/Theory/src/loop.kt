fun main(args: Array<String>) {
    var intRange = 0 .. 10

    var charRange = 'z'.downTo('b')

    for (i in intRange.reversed()){
        println(i)
    }

    for (i in charRange.reversed() step 3){
        print("$i \t")
    }

    for (i in 34.rangeTo(55).reversed()){
        println("$i")

    }










}