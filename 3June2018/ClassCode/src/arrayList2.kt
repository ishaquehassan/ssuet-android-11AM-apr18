fun main(args: Array<String>) {


    var list = arrayListOf<String>()

    for (insert in 0..10){
        list.add(readLine()!!)
    }

    for (get in list){

        println("value is $get")
    }
}