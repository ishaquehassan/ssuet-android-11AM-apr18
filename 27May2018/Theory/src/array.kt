fun main(args: Array<String>) {


    var name = "xyz"

    var direction = arrayOf(
            "East"
            ,"West"
            ,"North"
            ,"South")

    var marks = arrayOf(1,2,3,4)


//    println(direction[0][2])

//    println(marks[0])
//    marks[5] = 12
//    println(marks[0])
    marks = arrayOf(3)

    var expArray = intArrayOf()


    var array : Array<Int> = Array(10,{it*2})


    array[3] = 4

    for ((i,v) in direction.withIndex())
    {
        println("index $i value $v")
        direction[i] = "used $i $v"
    }



    for ((i,v) in direction.withIndex())
    {
        println("index $i value $v")
    }

    for (i in 2 until array.size step 2){
        println("$i = ${array[i]}")
    }

    (2+3)..(3*2)

    var (a,b) = Pair(2,"name")
    








}