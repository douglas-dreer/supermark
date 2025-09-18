package br.com.supermark.infrastructure.web.handlers

import br.com.supermark.domain.exceptions.ProductNotFoundException
import br.com.supermark.domain.exceptions.ValidationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException::class)
    fun handleValidationException(ex: ValidationException): ResponseEntity<Map<String, List<String?>>> {
        val body = mapOf("errors" to ex.errors)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body) // Erro 400
    }

    @ExceptionHandler(ProductNotFoundException::class)
    fun handleProductNotFoundException(ex: ProductNotFoundException): ResponseEntity<Map<String, String?>> {
        val body = mapOf("error" to ex.message)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body) // Erro 404
    }
}