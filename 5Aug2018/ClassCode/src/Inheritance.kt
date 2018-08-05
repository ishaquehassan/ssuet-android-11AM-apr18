open class UniPerson{
    private var name:String = ""
    var age:Int = 0
    var address:String = ""
}

class UniStudent : UniPerson(){
    val rollNo:String = ""
}

fun main(args: Array<String>) {
    val favStudent = UniStudent()
    favStudent.address
    favStudent.rollNo
}