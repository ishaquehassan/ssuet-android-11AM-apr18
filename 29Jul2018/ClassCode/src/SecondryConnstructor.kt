fun main(args: Array<String>) {
    CallingSecondConstructor()
}

class CallingSecondConstructor{

    lateinit var name:String
    var age:Int = 0

    init {
        println("hello")
    }


    constructor(name:String = "",age:Int = 0){
        this.name = name
        this.age = age
        println("Hello From 2")
    }

    constructor(name:String = ""/*,hello:Boolean = true*/){
        this.name = name
        println("Hello From 1")
    }


}