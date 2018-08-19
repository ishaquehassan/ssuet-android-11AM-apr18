import javax.print.attribute.standard.MediaSize

class Cart(var productName: String, var grandTotal:Int){
/*
    operator fun plus(other: Cart) : Int{

        return other.grandTotal+grandTotal
    }*/

    operator fun plus(other: Cart) : Cart{

        return Cart("final cart",other.grandTotal+grandTotal)
    }

    override fun toString(): String {
        return "Cart(productName='$productName', grandTotal=$grandTotal)"
    }


}


fun main(args: Array<String>) {
    println((Cart("a",23) + Cart("b",54)).toString())
}