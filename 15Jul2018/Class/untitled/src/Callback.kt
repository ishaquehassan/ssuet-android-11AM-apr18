fun main(args: Array<String>) {

    numbers(10,{ println("even $it") },{println("odd $it")})
}

fun numbers(number: Int, even: (Int) -> Unit, odd: (Int) -> Unit) {

    for (i in 1..number) {
        if (i % 2 == 0) {
            even(i)
        } else {
            odd(i)
        }
    }

}