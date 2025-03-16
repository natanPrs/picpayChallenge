package com.picpayChallenge.services

import com.picpayChallenge.domain.transactions.Transaction
import com.picpayChallenge.dtos.TransactionDto
import com.picpayChallenge.repositories.TransactionRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDate

@Service
class TransactionService(private val userService: UserService, private val transactionRepository: TransactionRepository) {

    fun createTransaction(transactionDto: TransactionDto): Transaction {
        val sender = userService.findUserById(transactionDto.sender)
        val receiver = userService.findUserById(transactionDto.receiver)

        userService.validateTransaction(sender, transactionDto.amount)

        val newTransaction = Transaction(
            sender = sender,
            receiver = receiver,
            amount = transactionDto.amount,
            localStamp = LocalDate.now() )

        sender.balance = sender.balance.subtract(transactionDto.amount)
        receiver.balance = receiver.balance.add(transactionDto.amount)

        userService.saveUser(sender)
        userService.saveUser(receiver)
        transactionRepository.save(newTransaction)

        return newTransaction
    }

    fun getAllTransactions(): List<Transaction> { return transactionRepository.findAll() }
}