package com.picpayChallenge.dtos

import com.picpayChallenge.domain.users.User
import java.math.BigDecimal

data class TransactionDto(
    val sender: Long,
    val receiver: Long,
    val amount: BigDecimal
)
