class CustomException(msg:String) : Exception(msg){
  /*  override val message: String?
        get() = "marks are less than 50"*/
}


fun main(args: Array<String>) {

    val name : String? = null


    try {
        //println(name!!.length)
        checkMarks(30)
    } catch (exception: Exception) {
        println(exception.message)
    }
}


fun checkMarks(marks: Int) {
    if (marks < 50) {
        throw CustomException("marks are less than 50")
    } else {
        println("OK")
    }
}
