package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class MainRestCtrl {

    @Autowired
    lateinit var usersDao:UsersDao

    @RequestMapping("/")
    fun home():String{
        return "Hello world spring"
    }

    @RequestMapping("/addUser",method = [RequestMethod.POST])
    fun addUser(
            @RequestParam("age") age:String,
            @RequestParam("fname") fname:String,
            @RequestParam("lname") lname:String
    ):Users{
        val u = Users(null,age.toInt(),fname,lname)
        usersDao.save(u)
        return u
    }

    @RequestMapping("/getAllUsers")
    fun getAllUsers():List<Users>{
        val u = usersDao.findAll().toList()
        if(u.isEmpty()){

        }else{

        }
        return u
    }


    @RequestMapping("/getByFname/{fname}")
    fun getByFname(@PathVariable("fname") fname:String):List<Users>{
        return usersDao.findByFname(fname)
    }


}