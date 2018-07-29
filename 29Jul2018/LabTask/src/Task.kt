class Task(val task:String,var isCompleted:Boolean = false)

val todo = arrayListOf<Task>()

fun main(args: Array<String>) {
    mainMenu()
}

fun mainMenu(){
    println("""
        1. Add
        2. List
        3. Mark Completed
    """.trimIndent())
    when(readLine()!!.toInt()){
        1 -> add()
        2 -> list()
        3 -> markCompleted()
    }
}

fun add(){
    println("Enter Task: ")
    todo.add(Task(readLine()!!))
    mainMenu()
}
fun list(){
    println("Pending")
    for (task in todo.filter { !it.isCompleted }){
        println(task.task)
    }
    println("Completed")
    for (task in todo.filter { it.isCompleted }){
        println(task.task)
    }
    mainMenu()
}

fun markCompleted(){
    println("Pending")
    for ((count, task) in todo.filter { !it.isCompleted }.withIndex()){
        println("$count = ${task.task}")
    }
    println("Enter Index to mark Complete:")
    todo[readLine()!!.toInt()].isCompleted = true
    mainMenu()
}