package br.com.lobolabs.ebalance.core.presentation.util.navigation

sealed interface AppRoutes {

    data class BottomNavigation(
        val items: List<AppScreens> = listOf(
            AppScreens.Home(),
            AppScreens.Sales(),
            AppScreens.Expenses(),
            AppScreens.Menu()
        )
    ) : AppRoutes

    data class Menu(
        val items: List<AppScreens> = listOf(
            AppScreens.Customers(),
            AppScreens.Receivers(),
            AppScreens.Providers(),
        )
    ) : AppRoutes

}