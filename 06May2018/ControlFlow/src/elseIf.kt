fun main(args: Array<String>) {


    var marks = 81




    if (marks >= 60 && marks <= 69) {
        println("B")
    } else if (marks >= 70 && marks <= 79) {
        println("A")
    } else if (marks >= 80 && marks <= 100) {
        println("A+")
    } else if (marks >= 50 && marks <= 59) {
        println("C")
    } else {
        println("fail")
    }

}