open class Vehicle{
    open fun startEngine(){
        println("Engine is Starting")
    }
}

open class Car: Vehicle(){

    override fun startEngine(){
        println("Car is Starting")
        super.startEngine()
    }
}

class Truck : Car(){
    fun hello(){
        super.startEngine()
    }
}

fun main(args: Array<String>) {
    val v = Vehicle()
    v.startEngine()

    val c = Car()
    c.startEngine()

    val t = Truck()
    t.hello()

    println(t)

}