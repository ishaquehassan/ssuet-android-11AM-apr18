package com.example.demo

import org.springframework.data.repository.CrudRepository

interface UsersDao : CrudRepository<Users,Long> {
    fun findByFname(fname:String):List<Users>
}