fun main(args: Array<String>) {
    val car1 = Car2("001")
    println(car1.model)
    println(car1.engineCC)
    println(car1.color)
}

class Car2(var model : String, var engineCC : Int = 2000){

     lateinit var color : String

    init {
        color = "black"
        val model = "890"
        println("before override "+this.model)

        this.model = "123"

        println("after override "+this.model)
        println(model)

        println(color)
    }

}