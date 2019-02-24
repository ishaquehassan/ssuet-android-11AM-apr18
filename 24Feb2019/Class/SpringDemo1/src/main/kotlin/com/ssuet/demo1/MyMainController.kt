package com.ssuet.demo1

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class MyMainController {

    @RequestMapping("/home")
    fun home(@RequestParam("id",required = false) id:String?,@RequestParam("name",required = false) name:String?):String{
        return "Hello world $name $id!"
    }

    @RequestMapping("/test/{id}")
    fun test(@PathVariable("id",required = false) id:String?):String{
        return "Test $id!"
    }

    @RequestMapping("/jsonApi.json")
    @ResponseBody
    fun jsonAPI():MyResponse{
        return MyResponse().apply {
            id = 1
            name = "Ishaq"
        }
    }

}