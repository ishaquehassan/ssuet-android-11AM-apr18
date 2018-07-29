fun main(args: Array<String>) {
    val myPhone = MobilePhone("S9",6F)
    myPhone.boot()
    val myPhone1 = MobilePhone("OPPO FIND X",6F)
    myPhone1.boot{
        myPhone1.loadHomeScreen()
    }
    println()

    if(myPhone.isNetWorkAvailable()){
        println("Yes Its available!")
    }
}

class MobilePhone(val model:String,val displaySize:Float){

    fun boot(){
        println("Booting $model of Screen Size ${this.displaySize} to ANDROID O")
    }


    fun boot(onBootCompleted:()->Unit){
        println("Booting $model of Screen Size ${this.displaySize} to ANDROID O")
        onBootCompleted()
    }

    fun loadHomeScreen(){
        println("$model Screen is here!")
    }

    fun isNetWorkAvailable():Boolean{
        println("Checking Network...")
        println("$model has network connection!")
        return true
    }

}