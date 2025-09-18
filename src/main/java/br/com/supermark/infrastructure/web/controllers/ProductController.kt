package br.com.supermark.infrastructure.web.controllers

import br.com.supermark.application.dtos.request.CreateProductRequest
import br.com.supermark.application.dtos.ProductDTO
import br.com.supermark.application.usecase.product.CreateProductUseCase
import br.com.supermark.application.usecase.product.DeleteProductByIdUseCase
import br.com.supermark.application.usecase.product.FindAllProductUseCase
import br.com.supermark.application.usecase.product.FindProductByBarCodeUseCase
import br.com.supermark.application.usecase.product.FindProductByIdUseCase
import br.com.supermark.application.usecase.product.UpdateProductUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(
    private val createProductUseCase: CreateProductUseCase,
    private val findAllProductUseCase: FindAllProductUseCase,
    private val findProductByIdUseCase: FindProductByIdUseCase,
    private val findProductByBarcodeUseCase: FindProductByBarCodeUseCase,
    private val updateProductUseCase: UpdateProductUseCase,
    private val deleteProductByIdUseCase: DeleteProductByIdUseCase
) {

    @GetMapping
    fun getAllProducts(): ResponseEntity<List<ProductDTO>> {
        return ResponseEntity.ok(findAllProductUseCase.execute())
    }

    @GetMapping("/{productId}")
    fun getProductById(@PathVariable("productId") productId: Long): ResponseEntity<ProductDTO?> {
        return ResponseEntity.ok(findProductByIdUseCase.execute(productId))
    }

    @GetMapping(params = ["barcode"])
    fun getProductByBarcode(@RequestParam("barcode", required = true) barcode: String): ResponseEntity<ProductDTO?> {
        return ResponseEntity.ok(findProductByBarcodeUseCase.execute(barcode))
    }

    @PostMapping
    fun saveProduct(@RequestBody productRequest: CreateProductRequest): ResponseEntity<ProductDTO> {
        val productSaved = createProductUseCase.execute(productRequest.toDTO())
        return ResponseEntity.ok(productSaved)
    }

    @PatchMapping("/{productId}")
    fun updateProduct(@PathVariable("productId") productId: Long, @RequestBody productRequest: CreateProductRequest): ResponseEntity<ProductDTO> {
        val productUpdated = updateProductUseCase.execute(productRequest.toDTO())
        return ResponseEntity.ok(productUpdated)
    }

    @DeleteMapping("/{productId}")
    fun deleteProductById(@PathVariable("productId") productId: Long): ResponseEntity<Unit> {
        deleteProductByIdUseCase.execute(productId)
        return ResponseEntity.ok(null)
    }
}