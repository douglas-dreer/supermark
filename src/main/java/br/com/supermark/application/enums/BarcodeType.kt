package br.com.supermark.application.enums

enum class BarcodeType(
    val type: String
) {
    EAN13("EAN13"),
    EAN8("EAN8"),
    UPC("UPC"),
    QRCODE("QRCODE"),
    CODE128("CODE128"),
    CODE39("CODE39"),
    CODE93("CODE93"),
    DATAMATRIX("DATAMATRIX"),
    INTERLEAVED2OF5("INTERLEAVED2OF5"),
    PDF417("PDF417"),
}