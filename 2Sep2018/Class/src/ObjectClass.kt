fun main(args: Array<String>) {
    checkAC(object :AC{
        override var temprature: Double = 23.0
    })

    MyObjectClass.temprature

    MySecondObject.myStaticProperty = "Hello"

    var secondObject = MySecondObject
    println(MySecondObject.myStaticProperty)
    println(secondObject.myStaticProperty)
    println(secondObject.baseUrl+"?q=aas")
}


var MyObjectClass = object :AC {

    override var temprature: Double = 12.0

    fun hello(){
        println("hello world")
    }

}

fun checkAC(ac:AC){
    println(ac.temprature)
}

object MySecondObject{

    var myStaticProperty:String = ""
    var baseUrl : String = "https:google.com"

}