 open class Person2(){

    var name : String = ""
    var age : Int = -1
    var email : String = ""
}

 class Student2() : Person2()
{

    var rollNumber : String = ""
}

 open class Person(var name : String,var age : Int ,var email : String){


 }

 class Student(n: String,
               a: Int,
               e: String,
               var rollNumber: String) :
         Person (n, a, e)
 {

 }

class Teacher : Person2(){
    var subject : String = ""
    var salary : Int = 0
}

fun main(args: Array<String>) {
    val student = Student("Ishaq",40,"hello@abc.com","12345")

    student.rollNumber
}






