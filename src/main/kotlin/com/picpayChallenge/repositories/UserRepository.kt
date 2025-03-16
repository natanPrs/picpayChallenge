package com.picpayChallenge.repositories

import com.picpayChallenge.domain.users.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>{

    fun findUserById(id: Long): User?

    fun findUserByDocument(document: String): User?
}