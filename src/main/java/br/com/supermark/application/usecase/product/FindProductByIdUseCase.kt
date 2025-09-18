package br.com.supermark.application.usecase.product

import br.com.supermark.application.dtos.ProductDTO
import br.com.supermark.application.ports.out.ProductRepositoryPort
import org.springframework.stereotype.Service

@Service
class FindProductByIdUseCase(
    private val productRepository: ProductRepositoryPort
) {
    fun execute(productId: Long): ProductDTO? {
        return productRepository.findById(productId)?.toDTO()
    }
}