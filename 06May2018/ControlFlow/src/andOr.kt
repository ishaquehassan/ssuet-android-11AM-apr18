fun main(args: Array<String>) {

    var age = 16


    println(age > 16)

    println(age < 16)

    println(age == 15)

    println(age <= 16)

    println(age >= 16)

    println(age == 16)


    println(age != 16)

    println(age != 15)

    println(false || true)

    println(true && true)

    println(false && true)

    println(false || false)

    println(age != 15 || age >= 16)

    println(age != 15 || age == 12)

    println(age != 15 && age == 12)

    println(age != 15 && age >= 16)


    println(age == 16 && age >= 16 || age < 15)

    println(age == 16 && age >= 16 && age < 15)

    //value of age is 16

    println((age != 16 && age >= 16)
            || (age == 12 || age < 15))

    println((age == 16 && age >= 16)
            && (age == 12 || age < 15))


}