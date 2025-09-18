// Local: src/main/kotlin/br/com/supermark/domain/validators/ProductValidator.kt
package br.com.supermark.domain.validators

import br.com.supermark.domain.entities.Product
import br.com.supermark.domain.exceptions.ValidationException
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class ProductValidator : Validator<Product> {
    override fun validate(model: Product) {
        val errors = mutableListOf<String>()

        if (model.name.isBlank()) {
            errors.add("O nome do produto não pode estar em branco.")
        }

        if (model.price <= BigDecimal.ZERO) {
            errors.add("O preço do produto deve ser maior que zero.")
        }

        if (errors.isNotEmpty()) {
            throw ValidationException(errors)
        }
    }
}