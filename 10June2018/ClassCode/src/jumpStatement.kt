

fun main(args: Array<String>) {

    for (i in 0..10){

        if (i == 5){
            break
        }
        println("loop $i")
    }


    println("after for loop")
    while (true)
    {
        println("Enter Value to Continue")
        if (readLine()!! == "quit"){
            break
        }
    }

    println("after while loop")

    do
    {
        println("Enter Value to Continue")
        if (readLine()!! == "quit"){
            break
        }
    }while (true)

}