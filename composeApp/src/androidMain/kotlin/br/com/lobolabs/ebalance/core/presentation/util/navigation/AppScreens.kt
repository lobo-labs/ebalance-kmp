package br.com.lobolabs.ebalance.core.presentation.util.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import br.com.lobolabs.ebalance.R
import br.com.lobolabs.ebalance.feature.contract.presentation.ContractScreen
import br.com.lobolabs.ebalance.feature.customer.CustomerScreen
import br.com.lobolabs.ebalance.feature.expense.ExpenseScreen
import br.com.lobolabs.ebalance.feature.home.HomeScreen
import br.com.lobolabs.ebalance.feature.launcher.LauncherScreen
import br.com.lobolabs.ebalance.feature.menu.MenuScreen
import br.com.lobolabs.ebalance.feature.provider.ProviderScreen
import br.com.lobolabs.ebalance.feature.receiver.ReceiverScreen
import br.com.lobolabs.ebalance.feature.sale.SaleScreen
import br.com.lobolabs.ebalance.feature.user.UserScreen

sealed interface AppScreens {
    val icon: Int
    val label: Int
    val route: String
    val screen: @Composable () -> Unit

    data class Launcher(
        @DrawableRes override val icon: Int = R.drawable.ic_ebalance,
        @StringRes override val label: Int = R.string.launcher,
        override val route: String = "launcher",
        override val screen: @Composable () -> Unit = { LauncherScreen() }
    ) : AppScreens

    data class Home(
        @DrawableRes override val icon: Int = R.drawable.ic_home,
        @StringRes override val label: Int = R.string.home,
        override val route: String = "home",
        override val screen: @Composable () -> Unit = { HomeScreen() }
    ) : AppScreens

    data class Sales(
        @DrawableRes override val icon: Int = R.drawable.ic_cash_in,
        @StringRes override val label: Int = R.string.sales,
        override val route: String = "sales",
        override val screen: @Composable () -> Unit = { SaleScreen() }
    ) : AppScreens

    data class Expenses(
        @DrawableRes override val icon: Int = R.drawable.ic_cash_out,
        @StringRes override val label: Int = R.string.expenses,
        override val route: String = "expenses",
        override val screen: @Composable () -> Unit = { ExpenseScreen() }
    ) : AppScreens

    data class Services(
        @DrawableRes override val icon: Int = R.drawable.ic_group,
        @StringRes override val label: Int = R.string.services,
        override val route: String = "services",
        override val screen: @Composable () -> Unit = { ReceiverScreen() }

    ) : AppScreens

    data class Customers(
        @DrawableRes override val icon: Int = R.drawable.ic_person,
        @StringRes override val label: Int = R.string.customers,
        override val route: String = "customers",
        override val screen: @Composable () -> Unit = { CustomerScreen() }
    ) : AppScreens

    data class Receivers(
        @DrawableRes override val icon: Int = R.drawable.ic_group,
        @StringRes override val label: Int = R.string.receivers,
        override val route: String = "receivers",
        override val screen: @Composable () -> Unit = { ReceiverScreen() }

    ) : AppScreens

    data class Providers(
        @DrawableRes override val icon: Int = R.drawable.ic_box,
        @StringRes override val label: Int = R.string.providers,
        override val route: String = "providers",
        override val screen: @Composable () -> Unit = { ProviderScreen() }
    ) : AppScreens

    data class Menu(
        @DrawableRes override val icon: Int = R.drawable.ic_menu,
        @StringRes override val label: Int = R.string.menu,
        override val route: String = "menu",
        override val screen: @Composable () -> Unit = { MenuScreen() }
    ) : AppScreens

    data class Contracts(
        @DrawableRes override val icon: Int = R.drawable.ic_contract,
        @StringRes override val label: Int = R.string.contracts,
        override val route: String = "contracts",
        override val screen: @Composable () -> Unit = { ContractScreen() }
    ) : AppScreens

    data class Users(
        @DrawableRes override val icon: Int = R.drawable.ic_user,
        @StringRes override val label: Int = R.string.users,
        override val route: String = "users",
        override val screen: @Composable () -> Unit = { UserScreen() }
    ) : AppScreens
}