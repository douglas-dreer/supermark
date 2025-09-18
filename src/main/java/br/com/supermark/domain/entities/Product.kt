package br.com.supermark.domain.entities

import br.com.supermark.application.dtos.ProductDTO
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "TBL_PRODUCTS")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var name: String = "",

    @Column(name = "barcode")
    val barCode: String? = null,

    @Column(name = "qrcode")
    val qrCode: String? = null,

    @Column(nullable = false)
    var price: BigDecimal = BigDecimal.ZERO,

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    val createdAt: LocalDateTime? = null,

    @UpdateTimestamp
    @Column(name = "updated_at")
    val updatedAt: LocalDateTime? = null

) {
    fun toDTO(): ProductDTO {
        return ProductDTO(
            id = id,
            name = name,
            price = price,
            barCode = barCode,
            createdAt = createdAt,
            updatedAt = updatedAt
        )
    }
}