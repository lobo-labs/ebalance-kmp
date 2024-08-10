package feature.financial.data.response

import kotlinx.serialization.Serializable

@Serializable
data class ExportData(
    var companyName: String,
    var companyId: String,
    var companyCode: String = "",
    var customerName: String,
    var emissionDate: String , // data de entrada - 21-01-2021 17:13:37
    var docNumber: String = "",
    var finishDate: String , // data de saida 17-08-2022
    var finishValue: Double,
    var operationDate: String, // data de marcado como pago/baixa - 21-01-2021 17:13:37
    var userName: String,
    var nominalValue: Double,
    var jurosValue: Double = 0.0,
    var lateDays: Int,
    var totalValue: Double,
    var jurosValuePercent: Double = 0.0,
    val employee: String = "",
    val dvBoleto: String = "",
    val cprRegion: String = "",
    val cfRegion: String = "",
)
