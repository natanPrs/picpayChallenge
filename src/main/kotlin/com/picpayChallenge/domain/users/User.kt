package com.picpayChallenge.domain.users

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "tb_user")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val fullName: String,

    @Column(unique = true)
    val document: String,

    @Column(unique = true)
    val email: String,

    val password: String,

    val balance: BigDecimal,

    @Enumerated(EnumType.STRING)
    val userType: UserType,

)
