fun main(args: Array<String>) {
    PS("hello",true)
}

class PS(var task:String){

    var isCompleted = false

    constructor(task:String,isCompleted:Boolean) : this(task){
        this.isCompleted = isCompleted
    }
}

