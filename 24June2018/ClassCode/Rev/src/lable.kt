fun main(args: Array<String>) {

    var condition = true
    var condition2 = true

    var number = 0
    outer@ while(condition){

        println("in outer loop before $number")

        while (condition2){
            number++
            println("in inner loop $number")
            if (number == 3){
                continue@outer
            }
            if (number == 4){
                break@outer
            }
        }

        println("in outer loop after $number")
    }

}