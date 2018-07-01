fun main(args: Array<String>) {

    10 add 20

    40.add(20)

}

infix fun Int.add(a:Int) = this+a

//infix fun Int.calling(vararg values:Int) = values.sum() infix not allow here in vararg


fun String.override(){
//        this = "arbaz"  not working
}