package br.com.supermark.application.ports.out

import br.com.supermark.domain.entities.Product

interface ProductRepositoryPort {
    fun findAll(): List<Product>
    fun findById(productId: Long): Product?
    fun findByBarCode(barcode: String): Product?
    fun save(product: Product): Product
    fun deleteById(productId: Long): Unit
    fun existsById(productId: Long): Boolean
}