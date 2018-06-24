fun main(args: Array<String>) {

    var number = 0

    while (true){

        println("in loop number $number")
        if (number==3){
            break
        }
        number++
    }

    number = 0
    while (true){
        println("before loop number = $number")
        number++
        if (number == 3) {
            continue
        }
        if (number == 5){
            break
        }
        println("after loop number = $number")

    }





}