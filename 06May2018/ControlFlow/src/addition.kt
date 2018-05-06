fun main(args: Array<String>) {
    var a :Int = 2

    var b : Int = 5

    var c:String = "the sum of $a and $b is ${a+b}"

    println("")


    var table = "employee"

    var column = "name"

    var value = "arbaz"


    println("select * from "+table+" where "+column +" = "+value)

    println("select * from $table where $column = $value")

}