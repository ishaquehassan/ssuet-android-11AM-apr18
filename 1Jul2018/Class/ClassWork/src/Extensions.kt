fun main(args: Array<String>) {
    var map = mapOf<String,String>(
            "name" to "ishaq",
            Pair("name","arbaz")
    )

    val name : String = "ishaq"

    name.printing()

    "".printing()

    1.printing()


    "name".add("ishaq")

    println(name.call())

    println(4278.rev())
}

fun Any.printing() {

    println(this)
}

fun String.add(value:String){
    println("$this $value")
}


fun String.call():String{

    return "$this from function"
}

fun Int.rev() = this.toString().split("").reversed().joinToString("").toInt()


