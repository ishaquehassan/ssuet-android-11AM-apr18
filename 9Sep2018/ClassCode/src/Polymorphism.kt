open class LivingThing(){
    open var name:String = "Just Living Thing"

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}
open class Human : LivingThing(){
    fun sleep(){

    }
}
open class Student : Human(){
    override var name: String
        get() = "Just Student"
        set(value) {}
    var rollNo:Int = 10
}
class CSStudent : Student()
class Plant : LivingThing()


fun main(args: Array<String>) {
    checkIt(Student())
}

fun checkIt(livingThing: Human){
    print(livingThing.name)
    if(livingThing is Student){
        print(livingThing.rollNo)
    }
}