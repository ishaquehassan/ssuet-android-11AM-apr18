fun main(args: Array<String>) {
    val marks = mutableMapOf<String,Int>()
    for (i in 0..5){
        println("Enter friend ${i+1} Subject name: ")
        val subName = readLine()!!
        println("Enter $subName marks: ")
        val subMarks = readLine()!!.toInt()
        marks[subName] = subMarks
    }

    for ((subject,mark) in marks){
        println("$subject marks are $mark")
    }
}