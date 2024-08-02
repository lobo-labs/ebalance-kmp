package core

import kotlinx.serialization.Serializable

@Serializable
data class AppError(
    val code: Int,
    val message: String,
    val throwable: String? = null
) {

    constructor(appErrorCode: AppErrorCode, throwable: Throwable? = null) : this(
        code = appErrorCode.ordinal,
        message = appErrorCode.message,
        throwable = throwable?.stackTraceToString()
    )

    constructor(message:String, throwable: Throwable? = null) : this(
        appErrorCode = AppErrorCode.values().find { it.message == message } ?: AppErrorCode.GENERIC_ERROR,
        throwable = throwable
    )
}

enum class AppErrorCode(val message: String) {

    REDE_ERROR("Erro da REDE"),

    GENERIC_ERROR("Não foi possível processar a solicitação, tente novamente mais tarde!"),

    // region Auth

    AUTH_ERROR("Usuário ou senha inválidos!"),
    AUTH_EMAIL_INVALID("E-mail com formato inválido!"),
    AUTH_PASSWORD_INVALID("A senha precisa ter pelo menos 8 caracteres!"),

    INVALID_DUE_DATE("Data de vencimento inválida!"),
    INVALID_DATE("Data com formato inválido!"),
    SEND_EMAIL_ERROR("Não foi possível enviar o e-mail, tente novamente mais tarde!"),
    CONTACT_TYPE_REQUIRED("Necessário informar a forma de contato!"),
    CONTACT_TYPE_INVALID("Forma de contato inválida!"),
    MESSAGE_TYPE_REQUIRED("Necessário informar o tipo de mensagem!"),
    MESSAGE_TYPE_INVALID("Tipo de mensagem inválida!"),

    // endregion Auth

    // region Params

    PARAMS_ACTIVE_STATUS_REQUIRED("Status de atividade obrigatório"),

    PARAMS_CONTRACT_ID_REQUIRED("ID do contrato não informado!"),
    PARAMS_CONTRACT_DISCOUNT_REQUIRED("Desconto do contrato não informado!"),

    PARAMS_COMPANY_CNPJ_INVALID("CNPJ da empresa com formato inválido!"),
    PARAMS_COMPANY_ID_REQUIRED("ID da empresa não informado!"),
    PARAMS_COMPANY_STATUS_INVALID("Status da empresa inválido!"),
    PARAMS_COMPANY_STATUS_REQUIRED("Status da empresa não informado!"),

    PARAMS_CUSTOMER_CNPJ_REQUIRED("CNPJ do cliente não informado!"),
    PARAMS_CUSTOMER_CNPJ_INVALID("CNPJ do cliente com formato inválido!"),
    PARAMS_CUSTOMER_NAME_REQUIRED("Nome do cliente não informado"),
    PARAMS_CUSTOMER_NAME_INVALID("Nome do cliente com formato inválido!"),
    PARAMS_CUSTOMER_PHONE_REQUIRED("Telefone do cliente não informado!"),
    PARAMS_CUSTOMER_PHONE_INVALID("Telefone do cliente com formato inválido!"),
    PARAMS_CUSTOMER_ID_INVALID("ID do cliente inválido!"),
    PARAMS_CUSTOMER_ID_REQUIRED("ID do cliente não informado"),

    PARAMS_USER_ID_INVALID("ID do usuário inválido"),
    PARAMS_USER_ID_REQUIRED("ID do usuário não informado"),
    PARAMS_USER_CPF_INVALID("CPF do usuário com formato inválido"),
    PARAMS_USER_CPF_REQUIRED("CPF do usuário não informado"),
    PARAMS_USER_EMAIL_INVALID("Email do usuário inválido"),
    PARAMS_USER_EMAIL_REQUIRED("Email do usuário não informado"),
    PARAMS_USER_NAME_INVALID("Nome do usuário inválido"),
    PARAMS_USER_NAME_REQUIRED("Nome do usuário não informado"),

    PARAMS_SERVICE_ID_INVALID("ID do serviço inválido"),
    PARAMS_SERVICE_ID_REQUIRED("ID do serviço não informado"),
    PARAMS_SERVICE_NAME_INVALID("Nome do serviço inválido"),
    PARAMS_SERVICE_NAME_REQUIRED("Nome do serviço não informado"),

    PARAMS_EXPENSE_ID_INVALID("ID da despesa inválido"),
    PARAMS_EXPENSE_ID_REQUIRED("ID da despesa não informado"),

    PARAMS_PROVIDER_ID_INVALID("ID do fornecedor inválido"),
    PARAMS_PROVIDER_ID_REQUIRED("ID do fornecedor não informado"),
    PARAMS_PROVIDER_NAME_INVALID("Nome do fornecedor inválido"),
    PARAMS_PROVIDER_NAME_REQUIRED("Nome do fornecedor não informado"),
    PARAMS_PROVIDER_CNPJ_INVALID("CNPJ do fornecedor inválido"),
    PARAMS_PROVIDER_CNPJ_REQUIRED("CNPJ do fornecedor não informado"),
    PARAMS_PROVIDER_PHONE_INVALID("Telefone do fornecedor inválido"),
    PARAMS_PROVIDER_PHONE_REQUIRED("Telefone do fornecedor não informado"),

    PARAMS_RECEIVER_ID_INVALID("ID do destinatário inválido"),
    PARAMS_RECEIVER_ID_REQUIRED("ID do destinatário não informado"),
    PARAMS_RECEIVER_NAME_INVALID("Nome do destinatário inválido"),
    PARAMS_RECEIVER_NAME_REQUIRED("Nome do destinatário não informado"),
    PARAMS_RECEIVER_CNPJ_INVALID("CNPJ do destinatário inválido"),
    PARAMS_RECEIVER_CNPJ_REQUIRED("CNPJ do destinatário não informado"),
    PARAMS_RECEIVER_PHONE_INVALID("Telefone do destinatário inválido"),
    PARAMS_RECEIVER_PHONE_REQUIRED("Telefone do destinatário não informado"),

    PARAMS_SALE_ID_INVALID("ID da venda inválido"),
    PARAMS_SALE_ID_REQUIRED("ID da venda não informado"),
    PARAMS_SALE_ENTRY_DATE_INVALID("Data de entrada da venda inválida"),
    PARAMS_SALE_ENTRY_DATE_REQUIRED("Data de entrada da venda não informada"),
    PARAMS_SALE_FINISH_DATE_INVALID("Data de vencimento da venda inválida"),
    PARAMS_SALE_FINISH_DATE_REQUIRED("Data de vencimento da venda não informada"),
    PARAMS_SALE_NOTES_INVALID("Observações da venda inválida"),
    PARAMS_SALE_NOTES_REQUIRED("Observações da venda não informado"),
    PARAMS_SALE_CUSTOMER_NAME_INVALID("Nome do cliente da venda inválido"),
    PARAMS_SALE_CUSTOMER_NAME_REQUIRED("Nome do cliente da venda não informado"),
    PARAMS_SALE_RECEIVER_NAME_INVALID("Nome do destinatário da venda inválido"),
    PARAMS_SALE_RECEIVER_NAME_REQUIRED("Nome do destinatário da venda não informado"),
    PARAMS_SALE_TOTAL_INVALID("Total da venda inválido"),
    PARAMS_SALE_TOTAL_REQUIRED("Total da venda não informado"),
    PARAMS_SALE_RECEIPT_IMAGE_INVALID("Comprovante de pagamento da venda inválido"),
    PARAMS_SALE_RECEIPT_IMAGE_REQUIRED("Comprovante de pagamento da venda não informado"),

    PARAMS_RELATION_TYPE_INVALID("Relationamento inválido"),
    PARAMS_RELATION_TYPE_REQUIRED("Tipo de relacionamento não informado"),

    PARAMS_SEARCH_DATA_REQUIRED("Parâmetro da busca não informado"),
    PARAMS_SEARCH_DATA_INVALID("Parâmetro da busca inválido"),
    PARAMS_SEARCH_TYPE_INVALID("Tipo da busca inválido"),

    PARAMS_CASH_IN_ID_REQUIRED("ID do recebimento não informado"),
    PARAMS_CASH_OUT_ID_REQUIRED("ID do pagamento não informado"),

    // endregion Params

    // region Body

    BODY_SIGN_IN_INVALID("Requisição de login inválida!"),
    BODY_SIGN_UP_INVALID("Requisição de cadastro inválida!"),
    BODY_UPDATE_PASS_INVALID("Requisição de alteração de senha inválida!"),
    BODY_USER_INVALID("Usuário com formato inválido!"),
    BODY_SERVICE_INVALID("Serviço com formato inválido!"),
    BODY_CUSTOMER_INVALID("Cliente com formato inválida!"),
    BODY_EXPENSE_INVALID("Despesa com formato inválido!"),
    BODY_PROVIDER_INVALID("Fornecedor com formato inválido!"),
    BODY_RECEIVER_INVALID("Destinatário com formato inválido!"),
    BODY_SALE_INVALID("Venda com formato inválido!"),
    BODY_SALE_ITEMS_INVALID("Venda com itens inválidos!"),
    BODY_SALE_DATES_INVALID("Data de entrada maior que data de vencimento!"),
    BODY_SALE_PAYMENT_DATE_INVALID("Data de pagamento invalida!"),
    BODY_SALE_PAYMENT_INVALID("Requisição de pagamento da venda com formato inválido!"),

    BODY_WHATSAPP_INVALID("Requisição de mensagem de Whatsapp inválida!"),

    // endregion Body

    // region Body Fields

    BODY_FIELD_COMPANY_ID_INVALID("ID da empresa inválido"),

    BODY_FIELD_SALE_ID_INVALID("ID da venda inválido"),
    BODY_FIELD_SALE_ENTRY_DATE_INVALID("Data de entrada da venda inválida"),
    BODY_FIELD_SALE_FINISH_DATE_INVALID("Data de vencimento da venda inválida"),
    BODY_FIELD_SALE_FINISH_DATE_LESS_THAN_ENTRY_DATE_INVALID("Data de vencimento da venda é menor que data de entrada"),

    BODY_FIELD_USER_NAME_INVALID("Nome do usuário inválido"),
    BODY_FIELD_USER_PHONE_INVALID("Telefone do usuário inválido"),
    BODY_FIELD_USER_EMAIL_INVALID("Email do usuário inválido"),
    BODY_FIELD_USER_CPF_INVALID("CPF do usuário inválido"),
    BODY_FIELD_USER_CPF_LENGHT_INVALID("CPF do usuário com tamanho inválido"),

    BODY_FIELD_COMPANY_PICTURE_INVALID("Foto da empresa inválida"),
    BODY_FIELD_COMPANY_NAME_INVALID("Nome da empresa inválido"),
    BODY_FIELD_COMPANY_COMPANY_NAME_INVALID("Razão social da empresa inválida"),
    BODY_FIELD_COMPANY_COMPANY_CNPJ_LENGTH_INVALID("CNPJ da empresa com tamanho inválido"),
    BODY_FIELD_COMPANY_COMPANY_PHONE_INVALID("Telefone da empresa inválido"),
    BODY_FIELD_COMPANY_COMPANY_PHONE_LENGTH_INVALID("Telefone da empresa com tamanho inválido"),
    BODY_FIELD_COMPANY_COMPANY_EMAIL_INVALID("Email da empresa inválido"),
    BODY_FIELD_COMPANY_COMPANY_CNPJ_INVALID("CNPJ da empresa inválido"),
    BODY_FIELD_COMPANY_COMPANY_MR_INVALID("Inscrição municipal inválido"),
    BODY_FIELD_COMPANY_COMPANY_SR_INVALID("Inscrição estadual inválido"),
    BODY_FIELD_COMPANY_ADDRESS_CEP_INVALID("CEP inválido"),
    BODY_FIELD_COMPANY_ADDRESS_STATE_INVALID("Estado inválido"),
    BODY_FIELD_COMPANY_ADDRESS_CITY_INVALID("Cidade inválida"),
    BODY_FIELD_COMPANY_ADDRESS_STREET_INVALID("Rua inválida"),
    BODY_FIELD_COMPANY_ADDRESS_NUMBER_INVALID("Número do endereço inválido"),
    BODY_FIELD_COMPANY_ADDRESS_COMP_INVALID("Complemento inválido"),
    BODY_FIELD_COMPANY_ADDRESS_HOOD_INVALID("Bairro inválido inválido"),
    BODY_FIELD_COMPANY_CNAE_CODE_INVALID("Código CNAE inválido"),
    BODY_FIELD_COMPANY_CNAE_DESC_INVALID("Descrição CNAE inválida"),
    BODY_FIELD_COMPANY_TAX_INFO_PREF_CODE_INVALID("Código da prefeitura inválido"),

    BODY_FIELD_COMPANY_CONTRACT_START_DATE_INVALID("Data de início do contrato inválido"),
    BODY_FIELD_COMPANY_CONTRACT_PREVIOS_CONTRACT_ID_INVALID("ID do contrato anterior inválido"),

    BODY_FIELD_CUSTOMER_NAME_INVALID("Nome do cliente inválido"),
    BODY_FIELD_CUSTOMER_CNPJ_INVALID("CPF/CNPJ do cliente inválido"),
    BODY_FIELD_CUSTOMER_EMAIL_INVALID("Email do cliente inválido"),
    BODY_FIELD_CUSTOMER_PHONE_INVALID("Telefone do cliente inválido"),
    BODY_FIELD_CUSTOMER_PHONE_LENGHT_INVALID("Telefone do cliente com tamanho inválido"),
    BODY_FIELD_CUSTOMER_ADDRESS_INVALID("Endereço do cliente inválido"),

    BODY_FIELD_PROVIDER_NAME_INVALID("Nome do fornecedor inválido"),
    BODY_FIELD_PROVIDER_EMAIL_INVALID("Email do fornecedor inválido"),
    BODY_FIELD_PROVIDER_PHONE_INVALID("Telefone do fornecedor inválido"),
    BODY_FIELD_PROVIDER_PHONE_LENGHT_INVALID("Telefone do fornecedor com tamanho inválido"),
    BODY_FIELD_PROVIDER_CNPJ_INVALID("CNPJ do fornecedor inválido!"),
    BODY_FIELD_PROVIDER_CNPJ_LENGTH_INVALID("CNPJ do fornecedor com tamanho inválido!"),
    BODY_FIELD_PROVIDER_ADDRESS_INVALID("Endereço do fornecedor inválido"),

    BODY_FIELD_RECEIVER_NAME_INVALID("Nome do destinatário inválido"),
    BODY_FIELD_RECEIVER_EMAIL_INVALID("Email do destinatário inválido"),
    BODY_FIELD_RECEIVER_CNPJ_INVALID("CNPJ do destinatário inválido"),
    BODY_FIELD_RECEIVER_CNPJ_LENGHT_INVALID("CNPJ do destinatário com tamanho inválido"),
    BODY_FIELD_RECEIVER_PHONE_INVALID("Telefone do destinatário inválido"),
    BODY_FIELD_RECEIVER_PHONE_LENGHT_INVALID("Telefone do destinatário com tamanho inválido"),
    BODY_FIELD_RECEIVER_ADDRESS_INVALID("Endereço do destinatáio inválido"),

    BODY_FIELD_EXPENSE_ID_INVALID("ID da despesa inválido"),
    BODY_FIELD_EXPENSE_PROVIDER_ID_INVALID("ID do fornecedor inválido"),
    BODY_FIELD_EXPENSE_DESCRIPTION_INVALID("Descrição da despesa inválida"),
    BODY_FIELD_EXPENSE_VALUE_INVALID("Valor da despesa inválido"),
    BODY_FIELD_EXPENSE_ENTRY_DATE_INVALID("Data de entrada da despesa inválida"),
    BODY_FIELD_EXPENSE_FINISH_DATE_INVALID("Data de vencimento da despesa inválida"),
    BODY_FIELD_EXPENSE_FINISH_DATE_LESS_THAN_ENTRY_DATE_INVALID("Data de vencimento da despesa é menor que data de entrada"),
    BODY_FIELD_EXPENSE_PAYMENT_DATE_REQUIRED("Data de pagamento da despesa é obrigatória"),
    BODY_FIELD_EXPENSE_PAYMENT_DATE_INVALID("Data de pagamento da despesa inválida"),

    BODY_FIELD_SERVICE_NAME_INVALID("Nome do serviço inválido"),
    BODY_FIELD_SERVICE_PRICE_INVALID("Preço do serviço inválido"),

    BODY_FIELD_CASH_IN_VALUE_INVALID("Valor de recebimento inválido"),
    BODY_FIELD_CASH_OUT_VALUE_INVALID("Valor de pagamento inválido"),

    // endregion Body Fields

    // region Database

    DATABASE_CUSTOMER_NOT_ADDED("Erro ao adicionar cliente!"),
    DATABASE_CUSTOMER_NOT_DELETED("Erro ao excluir cliente!"),
    DATABASE_CUSTOMER_NOT_FOUND("Cliente não encontrado!"),
    DATABASE_CUSTOMER_NOT_UPDATED("Erro ao atualizar cliente!"),

    DATABASE_SERVICE_NOT_ADDED("Erro ao adicionar serviço!"),
    DATABASE_SERVICE_NOT_DELETED("Erro ao excluir serviço!"),
    DATABASE_SERVICE_NOT_FOUND("Serviço não encontrado!"),
    DATABASE_SERVICE_NOT_UPDATED("Erro ao atualizar serviço!"),

    DATABASE_USER_NOT_ADDED("Erro ao adicionar usuário!"),
    DATABASE_USER_NOT_DELETED("Erro ao excluir usuário!"),
    DATABASE_USER_NOT_FOUND("Usuário não encontrado!"),
    DATABASE_USER_NOT_UPDATED("Erro ao atualizar usuário!"),
    DATABASE_USER_PASS_NOT_UPDATED("Erro ao atualizar senha do usuário!"),

    DATABASE_EXPENSE_NOT_ADDED("Erro ao adicionar despesa!"),
    DATABASE_EXPENSE_NOT_DELETED("Erro ao adicionar despesa!"),
    DATABASE_EXPENSE_NOT_FOUND("Despesa não encontrada!"),
    DATABASE_EXPENSE_NOT_UPDATED("Erro ao atualizar despesa!"),
    DATABASE_EXPENSE_ALREADY_CANCELLED("Despesa já está cancelada!"),

    DATABASE_PROVIDER_NOT_ADDED("Erro ao adicionar fornecedor!"),
    DATABASE_PROVIDER_NOT_DELETED("Erro ao excluir fornecedor!"),
    DATABASE_PROVIDER_NOT_FOUND("Fornecedor não encontrado!"),
    DATABASE_PROVIDER_NOT_UPDATED("Erro ao atualizar fornecedor!"),

    DATABASE_RECEIVER_NOT_ADDED("Erro ao adicionar destinatário!"),
    DATABASE_RECEIVER_NOT_DELETED("Erro ao excluir destinatário!"),
    DATABASE_RECEIVER_NOT_FOUND("Destinatário não encontrado!"),
    DATABASE_RECEIVER_NOT_UPDATED("Erro ao atualizar destinatário!"),

    DATABASE_SALE_NOT_ADDED("Erro ao adicionar venda!"),
    DATABASE_SALE_NOT_DELETED("Erro ao excluir venda!"),
    DATABASE_SALE_NOT_FOUND("Venda não encontrada!"),
    DATABASE_SALE_NOT_UPDATED("Erro ao atualizar venda!"),
    DATABASE_SALE_ALREADY_CANCELLED("Venda já está cancelada!"),

    DATABASE_COMPANY_NOT_ADDED("Erro ao adicionar empresa!"),
    DATABASE_COMPANY_NOT_DELETED("Erro ao excluir empresa!"),
    DATABASE_COMPANY_NOT_FOUND("Empresa não encontrado!"),
    DATABASE_COMPANY_NOT_UPDATED("Erro ao atualizar empresa!"),
    DATABASE_COMPANY_HAS_NO_CONTRACT("Empresa não possui contratos!"),

    DATABASE_CONTRACT_INVALID_UPDATE_TAXES("Não é possível atualizar taxas do contrato, ainda vigente!"),
    DATABASE_CONTRACT_ALREADY_UPDATED_TAXES("Contrato com taxas atualizadas!"),
    DATABASE_CONTRACT_ALREADY_FINISHED("Contrato já está marcado como finalizado!"),
    DATABASE_CONTRACT_ALREADY_PAID("Contrato já está marcado como pago!"),
    DATABASE_CONTRACT_NOT_ADDED("Erro ao adicionar contrato!"),
    DATABASE_CONTRACT_NOT_DELETED("Erro ao excluir contrato!"),
    DATABASE_CONTRACT_NOT_FOUND("Contrato não encontrado!"),
    DATABASE_CONTRACT_NOT_UPDATED("Erro ao atualizar contrato!"),
    DATABASE_CONTRACT_NOT_FINISHED("Erro ao finalizar contrato!"),
    DATABASE_CONTRACT_NOT_PAID("Erro ao marcar contrato como pago!"),
    DATABASE_CONTRACT_EXCEED_LIMIT("Mais de um contrato ativo!"),
    DATABASE_LAST_CONTRACT_NOT_FOUND("Último contrato não encontrado!"),

    DATABASE_RELATION_NOT_ADDED("Erro ao adicionar relacionamento!"),
    DATABASE_RELATION_NOT_DELETED("Erro ao excluir relacionamento!"),
    DATABASE_RELATION_NOT_FOUND("Relacionamento não encontrado!"),
    DATABASE_RELATION_NOT_UPDATED("Erro ao atualizar relacionamento!"),

    DATABASE_CASH_IN_NOT_ADDED("Erro ao adicionar recebimento!"),
    DATABASE_CASH_IN_NOT_FOUND("Recebimento não encontrado!"),
    DATABASE_CASH_INS_NOT_FOUND("Nenhum recebimento encontrado!"),
    DATABASE_CASH_IN_NOT_UPDATED("Erro ao atualizar recebimento!"),
    DATABASE_CASH_IN_BIGGER_THAN_REMAINING("Valor de recebimento ultrapassa valor pendente!"),

    DATABASE_CASH_OUT_NOT_ADDED("Erro ao adicionar pagamento!"),
    DATABASE_CASH_OUT_NOT_FOUND("Pagamento não encontrado!"),
    DATABASE_CASH_OUTS_NOT_FOUND("Nenhum pagamento encontrado!"),
    DATABASE_CASH_OUT_NOT_UPDATED("Erro ao atualizar pagamento!"),
    DATABASE_CASH_OUT_BIGGER_THAN_REMAINING("Valor de pagamento ultrapassa valor pendente!"),

    // endregion Database

    // region Access

    NOT_GRANT_ACCESS("Sem acesso a essa função"),

    // endregion Access

    // region Jwt

    JWT_TOKEN_NOT_FOUND("Token não informado!"),
    JWT_TOKEN_EXPIRED("Token expirado!"),
    JWT_TOKEN_INVALID("Token com formato inválido!"),
    JWT_TOKEN_INVALID_DATA("Token dados inválidos!"),
    JWT_NOT_GRANTED_ACCESS("Acesso não permitido!"),
    JWT_NOT_FEATURE_ACCESS("Sem acesso a essa funcionalidade!"),
    JWT_GET_DOCTOR_ERROR("Erro ao obter dados do solicitante!"),
    JWT_GET_USER_ERROR("Erro ao obter dados do solicitante!"),
    JWT_INVALID_SESSION("Sessão inválida"),
    JWT_USER_TYPE_INVALID("Parâmetro com formato inválido"),

    // endregion Jwt,

    CHANGE_PASS_ID_INVALID("Requisição contém parâmetro com formato inválido"),
    CHANGE_PASS_PASS_INVALID("Requisição contém parâmetro com formato inválido"),

    COMPANY_STATUS_PENDING("Empresa aguardando liberação, se necessário, contate o adiministador do sistema!"),
    COMPANY_STATUS_INACTIVE("Empresa inativa, caso deseje voltar a utilizar, contate o adiministador do sistema!"),
    COMPANY_STATUS_BLOCKED("Empresa bloqueada, se necessário, contate o administrador do sistema!"),
    COMPANY_STATUS_OVERDUE("Empresa com pendência financeira, se necessário contate o administrador do sistema!"),
    COMPANY_STATUS_NO_ACTIVE_CONTRACTS("Empresa sem contrato ativo, se necessário contate o administrador do sistema!"),
    COMPANY_STATUS_ALREADY_THE_SAME("Status da empresa já é o solicitado!"),
    COMPANY_STATUS_MANY_ACTIVE_CONTRACTS("Empresa com mais de um contrato ativo, contate o administrador!"),

    COMPANY_PAYMENT_METHOD_KIND_INVALID("Tipo da forma de pagamento invalido!"),
    COMPANY_PAYMENT_METHOD_REQUIRED("Necessario informar uma forma de pagamento!"),
    COMPANY_PAYMENT_AUTO_PAY_NOT_ENABLED("Pagamento automatico desativado!"),

    GET_FILE_ERROR("Erro ao obter arquivo!"),

    IMPORT_FILE_ERROR("Erro ao importar arquivo!"),
    IMPORT_CUSTOMERS_ERROR("Erro ao importar clientes do arquivo!"),
    IMPORT_SALES_ERROR("Erro ao importar clientes do arquivo!"),
    IMPORT_FILE_INVALID("Arquivo com formato inválido!"),

    STORAGE_FILE_NOT_FOUND("Imagem não encontrada!"),
    STORAGE_GET_FILE_ERROR("Erro ao buscar imagem!"),

    RECEIPT_SALE_CANCELLED("Não é possível inserir comprovante em venda cancelada!"),
    PAYMENT_SALE_CANCELLED("Não é possível alterar pagamento de uma venda cancelada!"),
    CASH_IN_SALE_INVALID("Não é possível incluir ou cancelar recebimentos em uma venda cancelada ou paga!"),
    CASH_OUT_EXPENSE_INVALID("Não é possível incluir ou cancelar pagamentos em uma despesa cancelada ou paga!"),
    PAYMENT_EXPENSE_CANCELLED("Não é possível alterar pagamento de uma despesa cancelada!"),

    SIGN_UP_SUCCESS_NO_EMAIL("Cadastro realizado com sucesso, porém não foi possível enviar e-mail de confirmação!")
}
