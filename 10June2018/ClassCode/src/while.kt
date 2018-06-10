fun main(args: Array<String>) {
    var myBoolean: Boolean = true

    while (myBoolean){
        println("Enter Value to Continue")

        if (readLine()!!.equals("quit")){
            myBoolean = false

        }
    }





}