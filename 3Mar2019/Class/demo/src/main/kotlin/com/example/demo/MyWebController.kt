package com.example.demo

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/web")
class MyWebController {

    @RequestMapping("/")
    fun homePage(model:Model):String{
        model.addAttribute("name","SSUET")
        return "home"
    }
}