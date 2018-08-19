fun main(args: Array<String>) {
    val getInterface = GetInterface()
    getInterface.hello()

//    var interface2 = MyInterface2
}

interface MyInterface{
    fun hello()
}

interface MyInterface2{
    fun world()
}
class GetInterface : MyInterface,MyInterface2{
    override fun world() {

    }

    override fun hello() {
        println("hello world")
    }
}