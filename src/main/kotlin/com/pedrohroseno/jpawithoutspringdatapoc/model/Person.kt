package com.pedrohroseno.jpawithoutspringdatapoc.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Person( val name: String? = null, val age: Int? = null){
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
}
