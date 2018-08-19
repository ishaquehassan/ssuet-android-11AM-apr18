
interface SmartPhone{
   fun getOSName() : String

    fun getAppsCount() : Int
}

interface featurePhone{
    fun sendSMS()
}

class SamsungPhone : SmartPhone,featurePhone{
    override fun getOSName(): String {
        return "android"
    }

    override fun getAppsCount(): Int {
    return 10
    }

    override fun sendSMS() {
     println("samsung sms sent")
    }


}

class Nokia3310 : featurePhone{
    override fun sendSMS() {
        println("3310 sms sent")
    }

}

fun main(args: Array<String>) {
    val s = SamsungPhone()
    val n = Nokia3310()

    sendSMS(s)
    sendSMS(n)

    getOS(s)
//    getOS(n)
}

fun sendSMS(featurePhone: featurePhone){
    featurePhone.sendSMS()
}

fun getOS(smartPhone: SmartPhone){
    smartPhone.getOSName()
}

