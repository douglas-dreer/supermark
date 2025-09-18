package br.com.supermark.application.usecase

import br.com.supermark.application.ports.out.SaleEventPublisherPort
import org.springframework.stereotype.Service

@Service
class CreateSaleUseCase(
    private val saleEventPublisher: SaleEventPublisherPort
) {
    fun execute(saleInfo: String) {
        println("🧠 [Application] Executando o caso de uso para criar a venda...")
        saleEventPublisher.publishSaleEvent(saleInfo)
        println("✅ [Application] Caso de uso finalizado. Evento de venda publicado.")
    }
}