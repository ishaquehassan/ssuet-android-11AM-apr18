fun main(args: Array<String>) {

    for (i in 0 .. 5){
        println("before continue $i")
        if (i == 2 || i == 4)
        {
            continue
        }
        println("after continue $i")
    }
    println("======\n======\n======")
    for (i in 0..5){

        println("outer start $i")

        for (j in 0..5){
            println("inner before continue $j")
            if (j == 2 || j == 4)
            {
                break
            }
            println("inner after continue $j")
        }

        println("outer end $i")

    }
}