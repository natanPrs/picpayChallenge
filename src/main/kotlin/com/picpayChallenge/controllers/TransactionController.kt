package com.picpayChallenge.controllers

import com.picpayChallenge.domain.transactions.Transaction
import com.picpayChallenge.dtos.TransactionDto
import com.picpayChallenge.services.TransactionService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/transactions")
class TransactionController(private val transactionService: TransactionService) {

    @PostMapping
    fun createTransaction(@RequestBody transactionDto: TransactionDto): ResponseEntity<Transaction> {
        val newTransaction = transactionService.createTransaction(transactionDto)
        return ResponseEntity(newTransaction, HttpStatus.CREATED)
    }

    @GetMapping
    fun getAllTransactions(): ResponseEntity<List<Transaction>> {
        val transactions = transactionService.getAllTransactions()
        return ResponseEntity(transactions,HttpStatus.OK)
    }
}