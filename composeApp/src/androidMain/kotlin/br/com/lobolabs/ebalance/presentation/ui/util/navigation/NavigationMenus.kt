package br.com.lobolabs.ebalance.presentation.ui.util.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import br.com.lobolabs.ebalance.R

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