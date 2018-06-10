fun main(args: Array<String>) {
    val contactBook = arrayListOf<Map<String,String>>()
    for (i in 1..3){
        val contactMap = mutableMapOf<String,String>()

        println("Enter Contact $i name:")
        contactMap["name"] = readLine()!!

        println("Enter Contact $i Phone:")
        contactMap["phone"] = readLine()!!

        println("Enter Contact $i Email:")
        contactMap["email"] = readLine()!!

        contactBook.add(contactMap)
    }

    println("Enter of the keys(name,phone,email) you want to search contact with")
    val searchKey = readLine()!!
    println("Enter value you want to search contact with its $searchKey")
    val searchValue = readLine()!!

    var isFound = false

    for (contact in contactBook){
        if(!contact.containsKey(searchKey)){
            println("Invalid Key entered")
            break
        }else{
            if(contact.containsValue(searchValue)){
                isFound = true
                println(contact)
                break
            }
        }
    }

    if(!isFound)
        println("No Contact found with $searchKey in its $searchValue")
}