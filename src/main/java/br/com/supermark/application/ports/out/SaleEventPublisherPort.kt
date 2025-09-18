package br.com.supermark.application.ports.out

interface SaleEventPublisherPort {
    fun publishSaleEvent(message: String)
}