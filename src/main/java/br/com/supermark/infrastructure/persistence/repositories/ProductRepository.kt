package br.com.supermark.infrastructure.persistence.repositories

import br.com.supermark.application.ports.out.ProductRepositoryPort
import br.com.supermark.domain.entities.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long>, ProductRepositoryPort