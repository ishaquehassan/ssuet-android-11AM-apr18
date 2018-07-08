fun main(args: Array<String>) {


    println("helloworld".sortAsc())

    println("hello world".toTitleCase())


    var arr = arrayOf("hello","world")

    arr = arr.map {
        it+"1"
    }.toTypedArray()



    println(arr.joinToString (" "))

    println("hello world again".toTileCaseInLine())

    var marksArr = arrayOf(10,40,60,90,80,30)

    println(arr.filter {
        it != "world1"
    }.joinToString(" "))

    println(marksArr.filter {
        it >=50
    }.joinToString(","))

    marksArr.forEach {

        println(it)
    }

}


fun String.sortAsc() = this.toCharArray().sorted().joinToString ("")


fun String.toTitleCase() : String {

    var temp = this.split(" ").toTypedArray()

    for (word in 0 until temp.size){
        temp[word] = temp[word].capitalize()
    }
    return  temp.joinToString(" ")
}


fun String.toTileCaseInLine() = this.split(" ")
        .map { it.capitalize() }
        .joinToString(" ")




