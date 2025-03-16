package com.picpayChallenge.repositories

import com.picpayChallenge.domain.transactions.Transaction
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository : JpaRepository<Transaction, Long> {
}