package br.com.supermark.application.usecase.product

import br.com.supermark.application.ports.out.ProductRepositoryPort
import br.com.supermark.domain.exceptions.ProductNotFoundException
import org.springframework.stereotype.Service

@Service
class DeleteProductByIdUseCase(
    private val productRepository: ProductRepositoryPort
) {
    fun execute(productId: Long) {
        validate(productId)
        return productRepository.deleteById(productId)
    }

    private fun validate(productId: Long) {
         if (existsProductById(productId).not()) {
             throw ProductNotFoundException("Produto não encontrado com o id ${productId}")
         }
    }

    private fun existsProductById(productId: Long): Boolean {
        return productRepository.existsById(productId)
    }
}