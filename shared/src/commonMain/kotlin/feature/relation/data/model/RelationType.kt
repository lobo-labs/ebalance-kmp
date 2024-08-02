package feature.relation.data.model

import kotlinx.serialization.Serializable

@Serializable
enum class RelationType(
    val id: String,
    val manageCompanies: RelationRoles,
    val manageCustomers: RelationRoles,
    val manageExpenses: RelationRoles,
    val manageFinancial: RelationFinancialRoles,
    val manageProviders: RelationRoles,
    val manageReceivers: RelationRoles,
    val manageSales: RelationRoles,
    val manageServices: RelationRoles,
    val manageUsers: RelationRoles,
    val canSendMessages: Boolean
) {
    OWNER(
        "Proprietário",
        manageCompanies = RelationRoles(true, true, true, true),
        manageCustomers = RelationRoles(true, true, true, true),
        manageExpenses = RelationRoles(true, true, true, true),
        manageFinancial = RelationFinancialRoles(true, true,true, true, true),
        manageProviders = RelationRoles(true, true, true, true),
        manageReceivers = RelationRoles(true, true, true, true),
        manageSales = RelationRoles(true, true, true, true),
        manageServices = RelationRoles(true, true, true, true),
        manageUsers = RelationRoles(true, true, true, false),
        canSendMessages = true
    ),
    ADMIN(
        "Administrador",
        manageCompanies = RelationRoles(true, true, true, true),
        manageCustomers = RelationRoles(true, true, true, true),
        manageExpenses = RelationRoles(true, true, true, true),
        manageFinancial = RelationFinancialRoles(true, true,true, true, true),
        manageProviders = RelationRoles(true, true, true, true),
        manageReceivers = RelationRoles(true, true, true, true),
        manageSales = RelationRoles(true, true, true, true),
        manageServices = RelationRoles(true, true, true, true),
        manageUsers = RelationRoles(true, true, true, false),
        canSendMessages = true
    ),
    EMPLOYEE(
        "Empregado",
        manageCompanies = RelationRoles(true, true, false, false),
        manageCustomers = RelationRoles(true, true, false, false),
        manageExpenses = RelationRoles(true, true, false, false),
        manageFinancial = RelationFinancialRoles(true, false, true,false, false),
        manageProviders = RelationRoles(true, true, false, false),
        manageReceivers = RelationRoles(true, true, false, false),
        manageSales = RelationRoles(true, true, false, false),
        manageServices = RelationRoles(true, true, false, false),
        manageUsers = RelationRoles(true, true, false, false),
        canSendMessages = true
    ),
    COUNTER(
        "Contador",
        manageCompanies = RelationRoles(true, false, false, false),
        manageCustomers = RelationRoles(true, false, false, false),
        manageExpenses = RelationRoles(true, false, false, false),
        manageFinancial = RelationFinancialRoles(true,  false, false,false, false),
        manageProviders = RelationRoles(true, false, false, false),
        manageReceivers = RelationRoles(true, false, false, false),
        manageSales = RelationRoles(true, false, false, false),
        manageServices = RelationRoles(true, false, false, false),
        manageUsers = RelationRoles(false, false, false, false),
        canSendMessages = false
    ),
}
