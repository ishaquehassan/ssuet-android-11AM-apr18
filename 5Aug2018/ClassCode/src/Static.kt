//package com.Arbaz
class Student (var name: String){


    companion object {
        var uniName : String = ""

        fun calling(){
            println("calling")
        }

    }

}

fun main(args: Array<String>) {

    Student.uniName = "SSUET"
    var s1 = Student("arbaz")

    println(s1.name)
    println(Student.uniName)

    Student.calling()



}

var name = ""

fun create(){}