package com.picpayChallenge.domain.transactions

import com.picpayChallenge.domain.users.User
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(name = "tb_transaction")
data class Transaction(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinTable(name = "tb_sender")
    val sender: User,

    @ManyToOne
    @JoinTable(name = "tb_receiver")
    val receiver: User,

    val amount: BigDecimal,

    val localStamp: LocalDate
)
