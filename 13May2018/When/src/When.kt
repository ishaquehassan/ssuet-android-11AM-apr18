fun main(args: Array<String>) {

    var name = "hi"

    var case1 = "hello"
    var case2 = "world"

    when (name) {
        case1 -> println("hello block")

        "world" -> println("world block")

        else -> {
            println("final block")
            println("default block")
        }
    }

    if (name == "hello") println("")

    else if (name == "world") println("")

    else println("")


}