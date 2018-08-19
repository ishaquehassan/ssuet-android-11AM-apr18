fun main(args: Array<String>) {
   val student1 = Student("arbaz","1234")
   val student2 = Student("ishaq","1234")

    println(student1 == student2)

}

class Student(var name: String, var rollNumber: String){

    override fun equals(other: Any?): Boolean {
        println("calling equals")
        return if (other is Student){
            other.rollNumber == rollNumber
        }
        else {
            false
        }
    }
}