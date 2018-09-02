fun main(args: Array<String>) {
    val car: Vehicle = Car()
//  var v : Vehicle = Vehicle()
    car.modelName


}


abstract class Vehicle(var year: Int) {
    var modelName: String = ""
    abstract fun drive()

    fun reFuel() {

    }

}

class Car() : Vehicle(12), AC {

    override var temprature: Double = 2.0

    override fun drive() {
        println("driving a car")
    }
}

interface AC {
    var temprature: Double
}