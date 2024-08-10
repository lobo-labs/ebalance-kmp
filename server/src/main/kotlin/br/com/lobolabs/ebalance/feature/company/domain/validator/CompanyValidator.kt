package br.com.lobolabs.ebalance.feature.company.domain.validator

import br.com.lobolabs.ebalance.backend.core.util.ktx.matchEmailRegex
import br.com.lobolabs.ebalance.core.data.ktx.runOnError
import common.CompanyAddress
import common.CompanyCnae
import common.CompanyData
import common.CompanyTaxInfo
import feature.company.data.CreateCompanyRequest
import core.ApiStatus
import core.AppError
import core.AppErrorCode
import io.ktor.http.HttpStatusCode

object CompanyValidator {
    fun isValid(request: CreateCompanyRequest): ApiStatus<String> {

        if (request.name.isEmpty()) {
            return ApiStatus.Error(
                HttpStatusCode.BadRequest.value,
                AppError(AppErrorCode.BODY_FIELD_COMPANY_NAME_INVALID)
            )
        }

        val validateData = isValid(request.data)
        validateData.runOnError { error -> return error }

        val validateAddress = isValid(request.address)
        validateAddress.runOnError { error -> return error }

        val validateCnae = isValid(request.cnae)
        validateCnae.runOnError { error -> return error }

        val validateTaxInfo = isValid(request.taxInfo)
        validateTaxInfo.runOnError { error -> return error }

        return ApiStatus.Success("Objeto da empresa válido!")
    }

    private fun isValid(data: CompanyData): ApiStatus<String> {

        if (data.companyName.isEmpty()) {
            return ApiStatus.Error(
                HttpStatusCode.BadRequest.value,
                AppError(AppErrorCode.BODY_FIELD_COMPANY_COMPANY_NAME_INVALID)
            )
        }

        if (data.cnpj.isEmpty()) {
            return ApiStatus.Error(
                HttpStatusCode.BadRequest.value,
                AppError(AppErrorCode.BODY_FIELD_COMPANY_COMPANY_CNPJ_INVALID)
            )
        }

        if (data.cnpj.length != 14) {
            return ApiStatus.Error(
                HttpStatusCode.BadRequest.value,
                AppError(AppErrorCode.BODY_FIELD_COMPANY_COMPANY_CNPJ_LENGTH_INVALID)
            )
        }

//        if (cnpj.isCnpj().not()) {
//            return Pair(HttpStatusCode.BadRequest, AppError(AppErrorCode.BODY_FIELD_COMPANY_COMPANY_CNPJ_INVALID))
//        }

        if (data.email.isEmpty() || data.email.matchEmailRegex().not()) {
            return ApiStatus.Error(
                HttpStatusCode.BadRequest.value,
                AppError(AppErrorCode.BODY_FIELD_COMPANY_COMPANY_EMAIL_INVALID)
            )
        }

        if (data.phone.isEmpty()) {
            return ApiStatus.Error(
                HttpStatusCode.BadRequest.value,
                AppError(AppErrorCode.BODY_FIELD_COMPANY_COMPANY_PHONE_INVALID)
            )
        }

        if (data.phone.length != 10 && data.phone.length != 11) {
            return ApiStatus.Error(
                HttpStatusCode.BadRequest.value,
                AppError(AppErrorCode.BODY_FIELD_COMPANY_COMPANY_PHONE_LENGTH_INVALID)
            )
        }

        data.municipalRegistration?.let {
            if (it.isEmpty()) {
                return ApiStatus.Error(
                    HttpStatusCode.BadRequest.value,
                    AppError(AppErrorCode.BODY_FIELD_COMPANY_COMPANY_MR_INVALID)
                )
            }
        }

        data.stateRegistration?.let {
            if (it.isEmpty()) {
                return ApiStatus.Error(
                    HttpStatusCode.BadRequest.value,
                    AppError(AppErrorCode.BODY_FIELD_COMPANY_COMPANY_SR_INVALID)
                )
            }
        }

        return ApiStatus.Success("Dados da empresa válidos!")
    }

    private fun isValid(address: CompanyAddress): ApiStatus<String> {

        if (address.postalCode.isEmpty()) {
            return ApiStatus.Error(
                HttpStatusCode.BadRequest.value,
                AppError(AppErrorCode.BODY_FIELD_COMPANY_ADDRESS_CEP_INVALID)
            )
        }

        if (address.state.isEmpty()) {
            return ApiStatus.Error(
                HttpStatusCode.BadRequest.value,
                AppError(AppErrorCode.BODY_FIELD_COMPANY_ADDRESS_STATE_INVALID)
            )
        }

        if (address.city.isEmpty()) {
            return ApiStatus.Error(
                HttpStatusCode.BadRequest.value,
                AppError(AppErrorCode.BODY_FIELD_COMPANY_ADDRESS_CITY_INVALID)
            )
        }

        if (address.street.isEmpty()) {
            return ApiStatus.Error(
                HttpStatusCode.BadRequest.value,
                AppError(AppErrorCode.BODY_FIELD_COMPANY_ADDRESS_STREET_INVALID)
            )
        }

        if (address.number.isEmpty()) {
            return ApiStatus.Error(
                HttpStatusCode.BadRequest.value,
                AppError(AppErrorCode.BODY_FIELD_COMPANY_ADDRESS_NUMBER_INVALID)
            )
        }

        address.complement?.let {
            if (it.isEmpty()) {
                return ApiStatus.Error(
                    HttpStatusCode.BadRequest.value,
                    AppError(AppErrorCode.BODY_FIELD_COMPANY_ADDRESS_COMP_INVALID)
                )
            }
        }



        if (address.neighborhood.isEmpty()) {
            return ApiStatus.Error(
                HttpStatusCode.BadRequest.value,
                AppError(AppErrorCode.BODY_FIELD_COMPANY_ADDRESS_HOOD_INVALID)
            )
        }

        return ApiStatus.Success("Endereço da empresa válido!")
    }

    private fun isValid(cnae: CompanyCnae): ApiStatus<String> {

        if (cnae.code.isEmpty()) {
            return ApiStatus.Error(
                HttpStatusCode.BadRequest.value,
                AppError(AppErrorCode.BODY_FIELD_COMPANY_CNAE_CODE_INVALID)
            )
        }

        if (cnae.description.isEmpty()) {
            return ApiStatus.Error(
                HttpStatusCode.BadRequest.value,
                AppError(AppErrorCode.BODY_FIELD_COMPANY_CNAE_DESC_INVALID)
            )
        }

        return ApiStatus.Success("CNAE da empresa válido!")
    }

    private fun isValid(taxInfo: CompanyTaxInfo): ApiStatus<String> {
        taxInfo.internalPrefectureCode?.let {
            if (it.isEmpty()) {
                return ApiStatus.Error(
                    HttpStatusCode.BadRequest.value,
                    AppError(AppErrorCode.BODY_FIELD_COMPANY_TAX_INFO_PREF_CODE_INVALID)
                )
            }
        }

        return ApiStatus.Success("Tributação da empresa válida!")
    }
}