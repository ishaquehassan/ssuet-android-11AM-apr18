
fun <T> max(collection: Collection<T>,less : (T,T) ->Boolean):T?{

    var maximumNumber : T?= null

    for (element in collection)
        if (maximumNumber == null || less(maximumNumber,element))
            maximumNumber = element
    return maximumNumber

}

fun <T> min(collection: Collection<T>,less : (T,T) ->Boolean):T?{

    var minimumNumber : T?= null

    for (element in collection)
        if (minimumNumber == null || less(minimumNumber,element))
            minimumNumber = element
    return minimumNumber

}

fun main(args: Array<String>) {
   val numbers = listOf(2,3,4,5,5,43)
    val n = numbers.count{it>3} //it

    println("total number greater than three are $n")
    val maxNumber = max(numbers){

        maximum, element ->

        maximum < element}

    val minNumber = min(numbers,{minimum,element->minimum > element})

    println("maximum Number of list is $maxNumber")
    println("minimum Number of list is $minNumber")


}

