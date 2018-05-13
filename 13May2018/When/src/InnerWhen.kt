fun main(args: Array<String>) {

    var age = 16
    var name = "arbaz"
    when{
        age > 16 ->{
            println("age is > 16")
        }
        age < 16 -> {
            println("age is < 16")

        }
        age == 16 -> {
            println("age is = 16")
        }
        (age <=16 && name == "ishaq")->{

        }
        else -> {
            println("else block")

        }
    }

    when (1==1){
        true->{
            if (name == ""){

            }
        }
        false->{

        }
//        "gh"->{
//
//        }
    }

}