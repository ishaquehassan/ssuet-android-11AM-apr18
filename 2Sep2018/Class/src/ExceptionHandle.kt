fun main(args: Array<String>) {
     ExceptionHandle()

}

class ExceptionHandle{
    lateinit var name :String

    init {
        name = "ishaq"
        try {
            println(name)
        }catch (e: kotlin.UninitializedPropertyAccessException){
            println("Error")
        }catch (e: Exception){
            println("main Error")
        }finally {
            println("finally")
        }
    }

}
