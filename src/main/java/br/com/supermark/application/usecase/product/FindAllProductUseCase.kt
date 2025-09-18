package br.com.supermark.application.usecase.product

import br.com.supermark.application.dtos.ProductDTO
import br.com.supermark.application.ports.out.ProductRepositoryPort
import org.springframework.stereotype.Service

@Service
class FindAllProductUseCase(
    private val productRepository: ProductRepositoryPort
) {
    fun execute(): List<ProductDTO> {
        return productRepository.findAll().map { it.toDTO() }
    }
}