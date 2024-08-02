package br.com.lobolabs.ebalance.core.presentation.util.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import br.com.lobolabs.ebalance.R

sealed interface NavigationItems {
    val icon: Int
    val label: Int

    data class Home(
        @DrawableRes override val icon: Int = R.drawable.ic_home,
        @StringRes override val label: Int = R.string.home
    ) : NavigationItems

    data class Sales(
        @DrawableRes override val icon: Int = R.drawable.ic_cash_in,
        @StringRes override val label: Int = R.string.sales
    ) : NavigationItems

    data class Expenses(
        @DrawableRes override val icon: Int = R.drawable.ic_cash_out,
        @StringRes override val label: Int = R.string.expenses
    ) : NavigationItems

    data class Customers(
        @DrawableRes override val icon: Int = R.drawable.ic_user,
        @StringRes override val label: Int = R.string.customers
    ) : NavigationItems

    data class Receivers(
        @DrawableRes override val icon: Int = R.drawable.ic_user_group,
        @StringRes override val label: Int = R.string.receivers
    ) : NavigationItems
    
    data class Providers(
        @DrawableRes override val icon: Int = R.drawable.ic_box,
        @StringRes override val label: Int = R.string.providers
    ) : NavigationItems

    data class Menu(
        @DrawableRes override val icon: Int = R.drawable.ic_menu,
        @StringRes override val label: Int = R.string.menu
    ) : NavigationItems
}