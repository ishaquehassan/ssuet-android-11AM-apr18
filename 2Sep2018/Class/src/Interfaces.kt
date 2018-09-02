fun main(args: Array<String>) {
    var aPerson : UniPerson = Teacher()

    aPerson = Student()
//    aPerson = staffMember()

}

interface UniPerson{

    fun getDepart() :String
}

class Teacher : UniPerson{
    override fun getDepart():String {
        return "Android"
    }

    var name :String = ""
}

class Student : UniPerson{
    override fun getDepart(): String {
        return "Java"
    }

    var name : String = ""
}

class staffMember{}
