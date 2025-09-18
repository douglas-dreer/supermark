package br.com.supermark.core.utils

import com.google.zxing.BarcodeFormat
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.oned.EAN13Writer
import com.google.zxing.qrcode.QRCodeWriter
import java.io.ByteArrayOutputStream

object BarcodeUtils {
    /**
     * Gera uma imagem de código de barras EAN-13.
     * @param barcodeText O número de 12 ou 13 dígitos a ser codificado.
     * @return Um array de bytes (ByteArray) representando a imagem PNG do código de barras.
     */
    fun generateEAN13BarcodePNG(barcodeText: String): ByteArray {
        val barcodeWriter = EAN13Writer()
        val textToEncode = if (barcodeText.length == 13) barcodeText.substring(0, 12) else barcodeText

        val bitMatrix = barcodeWriter.encode(textToEncode, BarcodeFormat.EAN_13, 300, 150)

        val pngOutputStream = ByteArrayOutputStream()
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream)
        return pngOutputStream.toByteArray()
    }

    /**
     * Gera uma imagem de QR Code.
     * @param content O texto ou URL a ser codificado no QR Code.
     * @return Um array de bytes (ByteArray) representando a imagem PNG do QR Code.
     */
    fun generateQRCodePNG(content: String): ByteArray {
        val qrCodeWriter = QRCodeWriter()
        val bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, 200, 200)
        val pngOutputStream = ByteArrayOutputStream()
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream)
        return pngOutputStream.toByteArray()
    }
}