
fun Person.gettingName() : String{
   return this.name
}

fun Student.Companion.settingName(){

}


var Person.isPaid : Boolean
    get() = fees > 0
    set(value)  {
        if (value){
            fees = 1000
        }
    }

fun main(args: Array<String>) {
    var person = Person()
    person.name = "arbaz"

    println(person.gettingName())

    Student.settingName()

    println(person.isPaid)
    println(person.fees)

    person.isPaid = true

    println(person.isPaid)
    println(person.fees)
    println(person.isPaid)
}