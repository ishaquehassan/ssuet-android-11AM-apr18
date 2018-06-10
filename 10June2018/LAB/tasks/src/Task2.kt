fun main(args: Array<String>) {
    val friends = arrayListOf<String>()
    for (i in 0..5){
        println("Enter friend ${i+1} name: ")
        friends.add(readLine()!!)
    }

    println("Enter friend Name you want to find")
    val friendToFind = readLine()!!
    if(friends.contains(friendToFind)){
        println("Found $friendToFind!")
    }else{
        println("Not Found any Friend with name $friendToFind")
    }
}