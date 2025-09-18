package br.com.supermark.application.usecase.product

import br.com.supermark.application.dtos.ProductDTO
import br.com.supermark.application.ports.out.ProductRepositoryPort
import br.com.supermark.domain.validators.ProductValidator
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CreateProductUseCase(
    private val productValidator: ProductValidator,
    private val productRepository: ProductRepositoryPort,
) {

    @Transactional
    fun execute(product: ProductDTO): ProductDTO {
        val entity = product.toEntity()
        productValidator.validate(entity)

        return productRepository.save(product.toEntity()).toDTO()
    }
}