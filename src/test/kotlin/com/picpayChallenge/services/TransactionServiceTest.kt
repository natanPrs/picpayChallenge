package com.picpayChallenge.services

import com.picpayChallenge.domain.users.User
import com.picpayChallenge.domain.users.UserType
import com.picpayChallenge.dtos.TransactionDto
import com.picpayChallenge.repositories.TransactionRepository
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.extension.ExtendWith
import java.math.BigDecimal
import kotlin.test.Test

@ExtendWith(MockKExtension::class)
class TransactionServiceTest(

    @MockK
    private val transactionRepository: TransactionRepository,

    @MockK
    private val userService: UserService,

    @InjectMockKs
    private val transactionService: TransactionService
) {

    @Test
    fun `should create a transaction successfully`(){
        val sender = User(
            System.nanoTime(),
            "Natan Pires",
            "99999999901",
            "npires@email.com",
            "passW",
            BigDecimal.valueOf(50),
            UserType.COMMON
        )

        val receiver = User(
            System.nanoTime(),
            "Pedro Pires",
            "99999999902",
            "ppires@email.com",
            "passW",
            BigDecimal.valueOf(50),
            UserType.COMMON
        )

        val request = TransactionDto(sender.id!!, receiver.id!!, BigDecimal.valueOf(10))


        every { userService.findUserById(sender.id!!) } returns sender
        every { userService.findUserById(receiver.id!!) } returns receiver
        every { userService.validateTransaction(any(), any()) } returnsArgument 0
        every { userService.saveUser(match { it.id == sender.id }) } returnsArgument 0
        every { userService.saveUser(match { it.id == receiver.id }) } returnsArgument 0
        every { transactionRepository.save(match { it.sender == sender }) } returnsArgument 0

        transactionService.createTransaction(request)

        verify(exactly = 1) { transactionRepository.save(any()) }
    }
}