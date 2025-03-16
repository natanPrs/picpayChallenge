package com.picpayChallenge.services

import com.picpayChallenge.domain.users.UserType
import com.picpayChallenge.dtos.UserDto
import org.assertj.core.api.Assertions.assertThat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.math.BigDecimal
import kotlin.test.Test

@SpringBootTest
class UserServiceTest(

    @Autowired
    private val userService: UserService
) {

    @Test
    fun `should create User successfully`(){
        val user = UserDto(
            fullName = "Natan Pires",
            document = "99999999901",
            email = "npires@email.com",
            password = "passW",
            balance = BigDecimal.valueOf(50),
            userType = UserType.COMMON
        )

        userService.createUser(user)

        val result = userService.findUserByDocument("99999999901")

        assertThat(result).isNotNull
        assertThat(result.fullName).isEqualTo(user.fullName)
        assertThat(result.document).isEqualTo(user.document)
    }
}