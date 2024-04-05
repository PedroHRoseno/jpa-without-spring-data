package com.pedrohroseno.jpawithoutspringdatapoc

import com.pedrohroseno.jpawithoutspringdatapoc.model.Person
import com.pedrohroseno.jpawithoutspringdatapoc.util.JPAUtil
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JpaWithoutSpringDataPocApplication

fun main(args: Array<String>) {
    runApplication<JpaWithoutSpringDataPocApplication>(*args)
}
