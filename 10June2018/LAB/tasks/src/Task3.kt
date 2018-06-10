fun main(args: Array<String>) {
    val friends = arrayListOf<String>()
    for (i in 0..5){
        println("Enter friend ${i+1} name: ")
        friends.add(readLine()!!)
    }

    println("Enter friend Name you want to find")
    val friendToFind = readLine()!!
    val indexFound =  friends.indexOf(friendToFind)
    println("Index found ${indexFound}")
    if(indexFound >= 0){
        println("Found $friendToFind at index $indexFound!")
    }else{
        println("Not Found any Friend with name $friendToFind")
    }
}