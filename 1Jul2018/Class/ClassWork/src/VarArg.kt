fun main(args: Array<String>) {

//    morePrint("hello","world","hi","hello")
    varargWith("arbaz","hello","world")

    varargWithSecond("hello","world", name = "arbaz")
}

fun morePrint(vararg data :String){
    for (i in data){
        println(i)
    }
}
fun varargWith(name:String,vararg data:String){
    for (i in data){
        println(i)
    }
    println(name)
}
fun varargWithSecond(vararg data:String,name:String){
    for (i in data){
        println(i)
    }
    println(name)

}