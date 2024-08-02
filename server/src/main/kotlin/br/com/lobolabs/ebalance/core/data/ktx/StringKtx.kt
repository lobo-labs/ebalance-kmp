package br.com.lobolabs.ebalance.core.data.ktx

import java.awt.image.BufferedImage
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.text.Normalizer
import java.util.Base64
import java.util.Calendar
import javax.imageio.ImageIO

fun String.toMilliseconds(): Long {

    val date = this.split("/")
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.DAY_OF_MONTH, date[0].toInt())
    calendar.set(Calendar.MONTH, date[1].toInt() - 1)
    calendar.set(Calendar.YEAR, date[2].toInt())
    calendar.set(Calendar.HOUR_OF_DAY, 0)
    calendar.set(Calendar.MINUTE, 0)
    calendar.set(Calendar.SECOND, 0)
    calendar.set(Calendar.MILLISECOND, 0)

    return calendar.timeInMillis

}

fun String.getAddress(): String? {
    var result: String? = this
    if (this.contains("Complemento: null", true)) {
        result = this.replace("Complemento: null", "")
    }
    if (this.contains("null", true)) {
        result = null
    } else {
        result?.trimEnd()
    }

    return result
}

fun String?.getDoubleValue(): Double {
    return this
        ?.replace("R$", "")
        ?.replace(".", "")
        ?.replace(",", ".")
        ?.toDouble() ?: 0.0
}

//fun String?.unformattedCpfCnpj(): String? {
//    return this
//        ?.replace(".", "")
//        ?.replace("-", "")
//        ?.replace("/", "")
//}

//fun String?.unformattedPhone(): String? {
//    return this
//        ?.replace("(", "")
//        ?.replace(")", "")
//        ?.replace(" ", "")
//        ?.replace("-", "")
//}

fun String.formattedCpfOrCnpj(): String {
    return try {
        when (this.length) {
            11 -> {
                "${this.substring(0, 3)}.${this.substring(3, 6)}.${this.substring(6, 9)}-${this.substring(9, 11)}"
            }

            14 -> {
                "${this.substring(0, 2)}.${this.substring(2, 5)}.${this.substring(5, 8)}/${
                    this.substring(
                        8,
                        12
                    )
                }-${this.substring(12, 14)}"
            }

            else -> {
                this
            }
        }
    } catch (t: Throwable) {
        this
    }
}

fun String.formattedPhone(): String {
    return try {
        when (this.length) {
            10 -> {
                "(${this.substring(0, 2)}) ${this.substring(2, 6)}-${this.substring(6, 10)}"
            }

            11 -> {
                "(${this.substring(0, 2)}) ${this.substring(2, 7)}-${this.substring(7, 11)}"
            }

            else -> {
                this
            }
        }
    } catch (t: Throwable) {
        t.printStackTrace()
        this
    }
}

fun String.formattedPostalCode(): String {
    return try {
        "${this.substring(0, 2)}.${this.substring(2, 5)}-${this.substring(5, 8)}"
    } catch (t: Throwable) {
        t.printStackTrace()
        this
    }
}

fun String.getFirstName(): String {
    if (this.length > 1) {
        return this.split(" ").first()
    }
    return this
}

fun String.removeAccents(): String {
    val REGEX_UNACCENT = "\\p{InCombiningDiacriticalMarks}+".toRegex()

    val temp = Normalizer.normalize(this, Normalizer.Form.NFD)
    return REGEX_UNACCENT.replace(temp, "")
}

fun String.resizeBase64Image(): String {
     val bytes = Base64.getDecoder().decode(this)
    val inputStream = ByteArrayInputStream(bytes)
    val bufferedImage = ImageIO.read(inputStream)

    val scaledImage = bufferedImage.getScaledInstance(30, 30, BufferedImage.SCALE_SMOOTH)
    val resizedImage = BufferedImage(30, 30, BufferedImage.TYPE_INT_RGB)

    val graphic = resizedImage.createGraphics()
    graphic.drawImage(scaledImage, 0, 0, null)
    graphic.dispose()

    val outputStream = ByteArrayOutputStream()
    ImageIO.write(resizedImage, "png", outputStream)
    return Base64.getEncoder().encodeToString(outputStream.toByteArray())
}
