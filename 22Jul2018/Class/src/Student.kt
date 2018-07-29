fun main(args: Array<String>) {
    val car1 = Car()
    val car2 : Car = Car()

    println(car1.model)
    car1.model = "002"

    println(car1.model)
    val car3 : Any = Car()
//    println(car2.model)
}

class Car{
    var model : String = "001"
    var engineCC : Int = 1000
}