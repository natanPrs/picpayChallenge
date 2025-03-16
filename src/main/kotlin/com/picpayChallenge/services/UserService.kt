package com.picpayChallenge.services

import com.picpayChallenge.domain.users.User
import com.picpayChallenge.domain.users.UserType
import com.picpayChallenge.dtos.UserDto
import com.picpayChallenge.exceptions.InsufficientBalanceException
import com.picpayChallenge.exceptions.InvalidUserTypeException
import com.picpayChallenge.mapper.toUserEntity
import com.picpayChallenge.repositories.UserRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class UserService(private val userRepository: UserRepository) {

    fun createUser(userDto: UserDto): User {
        val newUser = userDto.toUserEntity()
        return userRepository.save(newUser)
    }

    fun getAllUsers(): List<User>{ return userRepository.findAll() }

    fun findUserById(id: Long): User {
        return userRepository.findUserById(id) ?: throw Exception("User not found")
    }

    fun validateTransaction(sender: User, amount: BigDecimal){
        if (sender.userType == UserType.MERCHANT) {
            throw InvalidUserTypeException()
        }

        if (sender.balance < amount){
            throw InsufficientBalanceException()
        }
    }

    fun saveUser(user: User): User {
        return userRepository.save(user)
    }
}