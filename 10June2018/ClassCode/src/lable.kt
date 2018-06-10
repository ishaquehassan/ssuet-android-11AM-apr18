fun main(args: Array<String>) {

    outer@ for (i in 0..3){

        println("outer start $i")

       inner@ for (j in 0..3){
            println("inner before continue $j")
            if (i == 2)
            {
                continue@outer
            }
            println("inner after continue $j")
        }

        println("outer end $i")

    }



}