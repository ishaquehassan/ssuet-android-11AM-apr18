fun main(args: Array<String>) {
    var name = "arbaz"

    println("hello \t$name ")
    println("hello \n$name ")
    println("hello \' $name ")
    println("hello \" $name ")
    println("hello \$ $name ")
    println("hello \\ $name ")
//    //escape string


    var  raw = """
        >hello
        >   ======
        >world
        >|hello
    """.trimMargin(">")

    println(raw)

}