fun main(args: Array<String>) {
    val student1 = "arbaz"
    val student2 = "ishaq"

    println((student1 * student2)* student1)

    println(student1+student2)
}

operator fun String.times(other:String) = "${this[0]}${other[0]}"

operator fun String.plus(other: String) = this*other


