fun main(args: Array<String>) {

    var range: IntRange = 0 .. 10

    for (i in range) {
        print("$i \t")
    }

    println()

    for (i in range step 3) {
        print("$i \t")
    }

    println()

    for (i in 10 downTo 1 step 2) {
        print("$i \t")
    }
    println()

    for (i in 1 until 10){
        print("$i \t")

    }

    println()

    var name = "ishaq"

    for (i in name) {

        print("$i \t")
    }
    println(range)


}