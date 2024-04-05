package com.pedrohroseno.jpawithoutspringdatapoc.controller

import com.pedrohroseno.jpawithoutspringdatapoc.model.Person
import com.pedrohroseno.jpawithoutspringdatapoc.repository.PersonRepository
import com.pedrohroseno.jpawithoutspringdatapoc.util.JPAUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class PersonController() {

    val personRepository: PersonRepository = PersonRepository(JPAUtil.getEntityManager())
    @GetMapping
    fun getAllPersons(): List<Person> {
        return personRepository.findAll()
    }

    @PostMapping
    fun savePerson(@RequestBody person: Person){
        return personRepository.save(person)
    }

    @DeleteMapping("/{id}")
    fun deletePerson(@PathVariable id: Long){
        val person = personRepository.findById(id)
        return personRepository.delete(person)
    }

}