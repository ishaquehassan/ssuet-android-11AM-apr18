open class Hw{
    fun abc(){

    }
}

class HelloWorld(var name:String) : Hw(){
     override fun toString(): String {
        return "HelloWorld(name='$name')"
    }

    override fun equals(other: Any?): Boolean {
        val myObj = other as HelloWorld
        return myObj.name == name
    }
}

fun main(args: Array<String>) {
    val h = HelloWorld("Ishaq")
    val h1 = HelloWorld("Ishaq")
    println(h == h1)
}