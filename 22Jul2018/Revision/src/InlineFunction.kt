fun main(args: Array<String>) {
    higher {
        println("in lambda fun")
    }
}

inline fun higher(noinline lambda:()->Unit){
    println("in higher function before")
    lambda()
    params(lambda)
    println("in higher function after")

}

fun params(lambda:()->Unit){
    higher {
        println("in lambda fun")
    }
}