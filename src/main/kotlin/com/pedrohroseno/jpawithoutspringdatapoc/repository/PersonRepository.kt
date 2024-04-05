package com.pedrohroseno.jpawithoutspringdatapoc.repository

import com.pedrohroseno.jpawithoutspringdatapoc.model.Person
import javax.persistence.EntityManager


class PersonRepository(private val entityManager: EntityManager) {

    fun save(person: Person){
        val transaction = entityManager.transaction
        try {
            transaction.begin()
            entityManager.persist(person)
            transaction.commit()
        }catch (e: Exception){
            if (transaction.isActive) {
                transaction.rollback()
            }
            throw e
        }
    }

    fun findAll(): List<Person> {
        return entityManager.createQuery("SELECT p FROM Person p", Person::class.java).resultList
    }

    fun delete(person: Person?) {
        val transaction = entityManager.transaction
        try {
            transaction.begin()
            entityManager.remove(person)
            transaction.commit()
        } catch (e: Exception) {
            if (transaction.isActive) {
                transaction.rollback()
            }
            throw e
        }
    }

    fun update(person: Person) {
        val transaction = entityManager.transaction
        try {
            transaction.begin()
            entityManager.merge(person)
            transaction.commit()
        } catch (e: Exception) {
            if (transaction.isActive) {
                transaction.rollback()
            }
            throw e
        }
    }

    fun findById(id: Long): Person? {
        return entityManager.find(Person::class.java, id)
    }
}