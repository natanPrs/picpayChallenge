package com.picpayChallenge.domain.transactions

import com.picpayChallenge.domain.users.User
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "tb_transaction")
data class Transaction(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne
    val sender: User,

    @ManyToOne
    val receiver: User,

    val amount: BigDecimal,
)
