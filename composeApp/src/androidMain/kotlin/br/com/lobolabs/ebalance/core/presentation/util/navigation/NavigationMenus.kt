package br.com.lobolabs.ebalance.core.presentation.util.navigation

sealed interface NavigationMenus {

    data class BottomNavigation(
        val items: List<NavigationItems> = listOf(
            NavigationItems.Home(),
            NavigationItems.Sales(),
            NavigationItems.Expenses(),
            NavigationItems.Menu()
        )
    ) : NavigationMenus

    data class Menu(
        val items: List<NavigationItems> = listOf(
            NavigationItems.Customers(),
            NavigationItems.Receivers(),
            NavigationItems.Providers(),
        )
    ) : NavigationMenus

}