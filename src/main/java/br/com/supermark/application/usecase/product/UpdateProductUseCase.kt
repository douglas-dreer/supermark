package br.com.supermark.application.usecase.product

import br.com.supermark.application.dtos.ProductDTO
import br.com.supermark.application.ports.out.ProductRepositoryPort
import br.com.supermark.domain.entities.Product
import br.com.supermark.domain.exceptions.ProductNotFoundException
import br.com.supermark.domain.validators.ProductValidator
import org.springframework.stereotype.Service

@Service
class UpdateProductUseCase(
    private val productValidator: ProductValidator,
    private val productRepository: ProductRepositoryPort
) {
    fun execute(product: ProductDTO): ProductDTO? {
        val productToSave = product.toEntity()
        validate(productToSave)
        return productRepository.save(productToSave).toDTO()
    }

    private fun validate(product: Product) {
        productValidator.validate(product)

        if (existsProductById(product.id!!).not()) {
            throw ProductNotFoundException("Produto não encontrado com o id ${product.id}")
        }
    }

    private fun existsProductById(productId: Long): Boolean {
        return productRepository.existsById(productId)
    }
}