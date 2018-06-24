fun main(args: Array<String>) {

    do {
        println("print statement in do while loop")
    } while (false)




    do {
        var condition: Boolean = true

        println("in second loop")
        if (readLine()!! == "hello") {
            condition = false
        }

    } while (condition)


}

