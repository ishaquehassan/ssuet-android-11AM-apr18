fun main(args: Array<String>) {

    var anyValue : Any = "hello world"

    println(anyValue)

    anyValue = 123

    println(anyValue)

    anyValue = "hello"

    println(anyValue)

    var number = 123

//    println(anyValue.length)

    if (anyValue !is String) {
        println(anyValue.length)
    } else if (anyValue is Int) {
        println(anyValue.plus(2))
    } else if (anyValue is Float) {

    }


    var casted = anyValue as Int

//    "Hello World".len

    when (anyValue) {
        is String -> println("any value is String")
        is Int -> println("any value is Int")
        is Float -> println("any value is Float")
        is Double -> println("any value is Double")
        is Boolean -> println("any value is Boolean")
        is Char -> println("any value is Char")
    }

//    casted.length


}