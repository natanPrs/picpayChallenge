package com.picpayChallenge.controllers

import com.picpayChallenge.domain.users.User
import com.picpayChallenge.dtos.UserDto
import com.picpayChallenge.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @PostMapping
    fun createUser(@RequestBody userDto: UserDto): ResponseEntity<User> {
        val newUser = userService.createUser(userDto)
        return ResponseEntity(newUser, HttpStatus.CREATED)
    }

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<User>>{
        val users = userService.getAllUsers()
        return ResponseEntity(users, HttpStatus.OK)
    }
}