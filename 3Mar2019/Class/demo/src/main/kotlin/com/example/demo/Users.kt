package com.example.demo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Users(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = null,
        val age: Int? = null,
        val fname: String? = null,
        val lname: String? = null
) {
    constructor():this(null,null,null,null)
}