package br.com.supermark.application.dtos

import br.com.supermark.domain.entities.Product
import java.math.BigDecimal
import java.time.LocalDateTime

data class ProductDTO(
    val id: Long? = null,
    val name: String,
    val price: BigDecimal,
    val barCode: String? = null,
    val qrCode: String? = null,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null
) {
    fun toEntity(): Product {
        return Product(
            id = id,
            name = name,
            price = price,
            barCode = barCode,
            qrCode = qrCode,
            createdAt = createdAt,
            updatedAt = updatedAt
        )
    }
}