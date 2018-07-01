fun main(args: Array<String>) {

    var arr = intArrayOf(1, 4, 5, 67)
    println(sumup(1, 3, *arr, 4, 5, 6))
    println(sumup(*arr))
    max(2,3)
}

fun sumup(vararg values: Int) = values.sum()

fun max(a: Int, b: Int) = if (a > b) {
    a
} else {
    b
}

