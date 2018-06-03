fun main(args: Array<String>) {



    var age = mapOf("ishaq" to 23,"usman" to 55)

    var friends = mapOf<String,String>("ishaq" to "usman","arbaz" to "usman", "ishaq" to "arbaz")

    var ranks = mapOf<Any,String>(3 to "hello")

    for ((key,value) in age){
        println("key $key and value $value")
    }

    for (key in age)
    {
        println(key)
    }

    println(friends["ishaq"])


    age += ("sameer" to 24)
    age += ("harris" to 43)
    age += ("kamran" to 29)

    age.plus("anyone" to 234)




}