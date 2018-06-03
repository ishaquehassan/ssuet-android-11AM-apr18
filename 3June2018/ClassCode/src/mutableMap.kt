fun main(args: Array<String>) {
    var map = mutableMapOf(
            Pair(3,"")
    )

    map.put(2 , "Ishaq")
    map[3] = "Arbaz"

    for ((key,value) in map){
        println("key $key value $value")
    }

}