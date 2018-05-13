fun main(args: Array<String>) {
    var name = "hello world";
    val age = 12 ; var b = "hi"

    name = "ishaq"


    //this var is  for age  single line comment

    /*this var is  for age

    this var is  for age

    this var is  for age multi line*/

    if (true)
    {
       println("in if block")
    }else{
        println("in else block")

    }

    var condition = age > 13

    var condition2 = age < 13

    println(condition)

    if (condition && condition2){
        println("in if condition block")
    }else{
        println("in else condition block")

    }

    if (condition || condition2){
        println("in if condition block")
    }else{
        println("in else condition block")

    }

}