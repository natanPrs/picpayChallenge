package com.picpayChallenge.infra

import com.picpayChallenge.exceptions.InsufficientBalanceException
import com.picpayChallenge.exceptions.InvalidUserTypeException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.nio.file.attribute.UserPrincipalNotFoundException

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(InvalidUserTypeException::class)
    fun handleInvalidUserTypeException(ex: InvalidUserTypeException) : ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.message)
    }

    @ExceptionHandler(InsufficientBalanceException::class)
    fun handleInvalidUserTypeException(ex: InsufficientBalanceException) : ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.message)
    }

    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleDataIntegrityViolationException(ex: DataIntegrityViolationException) : ResponseEntity<String>{
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is already registered.")
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadableException(ex: HttpMessageNotReadableException) : ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The data provided is invalid.")
    }

    @ExceptionHandler(Exception::class)
    fun handleGeneralException(ex: Exception) : ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.")
    }
}