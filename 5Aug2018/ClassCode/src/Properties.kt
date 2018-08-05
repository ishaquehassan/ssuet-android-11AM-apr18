
//import com.Arbaz.*

class Person {
    var fees:Int = 0
    var name : String = ""
        set(value) {
            println("updating name")
            field = value
        }
        get() {
            println("getting name form person class")
            if (field.length > 0) {
                return "$field hey"
            }
            else{
                return "nothing"
            }

        }

    var age: Int = -1

    val canCastVote : Boolean
    get(){
        return age>18
    }



}


fun main(args: Array<String>) {
    val person1 = Person()


    person1.name = "ishaq"
    person1.age = 12
    println(person1.name)

    println("this user can vote ${person1.canCastVote}")
//    name
//    create()
}



