package common

enum class CompanyPlans(
    val description: String,
    val monthlyPayment: Double,
    val usersQuantity: Int, // Quantidade de usuários
    val hasSaleServiceManagement: Boolean, // Gestão de Venda de Serviços
    val hasSaleProductManagement: Boolean, // Gestão de Vendas de Produtos
    val hasContractManagement: Boolean, // Gestão de Contratos
    val hasFinancialManagement: Boolean, // Controle Financeiro
    val hasStockManagement: Boolean, // Gestão de Estoques
    val hasNfseEmission: Boolean, // Emissão de NFS-e
    val hasNfeEmission: Boolean, // Emissão de NF-e
    val hasTicketEmission: Boolean, // Emissão de Boletos
    val hasCounterIntegration: Boolean, // Integração com o Contador
    val hasUserManagement: Boolean, // Controle de Permissões de Acesso
    val canSendSmsMessage: Boolean, // Controle de Permissões de Acesso
    val canSendWhatsappMessage: Boolean, // Controle de Permissões de Acesso
) {
    STANDARD(
        description = "Padrão",
        monthlyPayment = 120.0,
        usersQuantity = 15,
        hasSaleServiceManagement = true,
        hasSaleProductManagement = false,
        hasContractManagement = true,
        hasFinancialManagement = true,
        hasStockManagement = false,
        hasNfseEmission = false,
        hasNfeEmission = false,
        hasTicketEmission = true,
        hasCounterIntegration = true,
        hasUserManagement = true,
        canSendSmsMessage = false,
        canSendWhatsappMessage = false
    ),
    ADVANCED(
        "Avançado",
        monthlyPayment = 150.0,
        usersQuantity = 50,
        hasSaleServiceManagement = true,
        hasSaleProductManagement = false,
        hasContractManagement = true,
        hasFinancialManagement = true,
        hasStockManagement = false,
        hasNfseEmission = false,
        hasNfeEmission = false,
        hasTicketEmission = true,
        hasCounterIntegration = false,
        hasUserManagement = true,
        canSendSmsMessage = true,
        canSendWhatsappMessage = false
    ),
    PRO(
        "Profissional",
        200.0,
        usersQuantity = -1,
        hasSaleServiceManagement = true,
        hasSaleProductManagement = true,
        hasContractManagement = true,
        hasFinancialManagement = true,
        hasStockManagement = true,
        hasNfseEmission = true,
        hasNfeEmission = true,
        hasTicketEmission = true,
        hasCounterIntegration = true,
        hasUserManagement = true,
        canSendSmsMessage = true,
        canSendWhatsappMessage = true
    )
}
