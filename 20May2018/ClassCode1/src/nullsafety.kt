fun main(args: Array<String>) {

    var nullable = null
    var nonNullable : String = "value"
    var nullSaftey : String? = null

    nullSaftey = "hello"

    println(nullSaftey?.length)

    var name : String? = readLine()
//        "".length
    println(name?.length)

    var myNullable : String? = null

    println(myNullable?.length ?: "no length found")

    var mtStrLength : Int = myNullable?.length ?: 0
    println(mtStrLength)


    println(null ?: "hello")

    println("hello" ?: "nohello")












}