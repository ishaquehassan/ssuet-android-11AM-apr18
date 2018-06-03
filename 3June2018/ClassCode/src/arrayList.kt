fun main(args: Array<String>) {

    var list = arrayListOf<Int>()

    for(i in list){
        println(i)
    }
    println(list.size)

    list.add(23)
    list.add(24)
    list.add(56)
    list.add(78)
    list.add(22)


    println("after add")
    for(i in list){
        println(i)
    }

    println("after loop")


    println(list[0])
    println(list[3])
    println(list.get(4))
    println(list.get(1))

    println("${list.size} size of list")

    list.add(2,3)

    list[3] = 3

    println("after update ${list[2]}")


    for ((a,b) in list.withIndex())
    {
        println("index $a value $b")
    }




}





