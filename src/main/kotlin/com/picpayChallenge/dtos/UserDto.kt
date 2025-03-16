package com.picpayChallenge.dtos

import com.picpayChallenge.domain.users.UserType
import java.math.BigDecimal

data class UserDto(
    var fullName: String,
    var document: String,
    val email: String,
    val password: String,
    val balance: BigDecimal,
    val userType: UserType,
)
