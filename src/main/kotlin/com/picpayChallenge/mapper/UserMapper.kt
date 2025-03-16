package com.picpayChallenge.mapper

import com.picpayChallenge.domain.users.User
import com.picpayChallenge.dtos.UserDto

fun UserDto.toUserEntity(): User =
    User(
        id = null,
        fullName = this.fullName,
        document = this.document,
        email = this.email,
        password = this.password,
        balance = this.balance,
        userType = this.userType
    )
