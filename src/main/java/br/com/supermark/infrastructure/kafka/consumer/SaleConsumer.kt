package br.com.supermark.infrastructure.kafka.consumer

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class SaleConsumer {

    @KafkaListener(topics = ["sales-topic"], groupId = "sales-group")
    fun listen(message: String) {
        println("📥👂 [Adapter Kafka Consumer] MENSAGEM RECEBIDA! Conteúdo: '$message'")
    }
}