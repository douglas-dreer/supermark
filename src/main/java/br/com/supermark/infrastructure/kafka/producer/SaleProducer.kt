package br.com.supermark.infrastructure.kafka.producer

import br.com.supermark.application.ports.out.SaleEventPublisherPort
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class SaleProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>,
): SaleEventPublisherPort {

    override fun publishSaleEvent(message: String) {
        println("🗣️ [Adapter Kafka] Enviando mensagem para o tópico de vendas: '$message'")
        kafkaTemplate.send("sales-topic", message)
    }

}