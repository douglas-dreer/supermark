package br.com.supermark.infrastructure.web.controllers

import br.com.supermark.application.usecase.CreateSaleUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sales")
class SaleController(
    private val createSaleUseCase: CreateSaleUseCase
) {

    @PostMapping
    fun createSale(@RequestBody message: String): ResponseEntity<Void> {
        println("▶️ [API] Requisição recebida para criar venda com a mensagem: '$message'")
        createSaleUseCase.execute(message)
        return ResponseEntity.ok().build()
    }
}