package br.com.supermark.application.dtos

import br.com.supermark.application.enums.BarcodeType

data class BarcodeDTO(
    val type: BarcodeType = BarcodeType.EAN13,
    val code: String? = null,
    val image: ByteArray
) {
}