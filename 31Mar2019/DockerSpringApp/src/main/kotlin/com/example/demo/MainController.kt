package com.example.demo

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController{

    @RequestMapping("/")
    fun index():String = "hello world"
}