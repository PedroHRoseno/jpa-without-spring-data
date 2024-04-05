package com.pedrohroseno.jpawithoutspringdatapoc.util

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

object JPAUtil {
    private val entityManagerFactory: EntityManagerFactory by lazy {
        Persistence.createEntityManagerFactory("myPersistenceUnit")
    }

    fun getEntityManager(): EntityManager {
        return entityManagerFactory.createEntityManager()
    }

    fun close() {
        entityManagerFactory.close()
    }
}