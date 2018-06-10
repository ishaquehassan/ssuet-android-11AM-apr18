fun main(args: Array<String>) {
    val friends = arrayListOf<String>()
    for (i in 0..5){
        println("Enter friend ${i+1} name: ")
        friends.add(readLine()!!)
    }

    for (friend in friends){
        println(friend)
    }
}