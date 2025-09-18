package br.com.supermark.application.dtos.request

import br.com.supermark.application.dtos.ProductDTO
import java.math.BigDecimal

data class CreateProductRequest(
    val name: String,
    val price: BigDecimal,
    val barCode: String? = null,
    val qrCode: String? = null
) {
    fun toDTO(): ProductDTO {
        return ProductDTO(
            id = null,
            name = name,
            price = price,
            qrCode = qrCode,
            barCode = barCode,
            createdAt = null,
            updatedAt = null
        )
    }
}