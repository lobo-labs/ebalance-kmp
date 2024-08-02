import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.lobolabs.ebalance.core.presentation.util.AppTheme
import br.com.lobolabs.ebalance.feature.customer.CustomerScreen
import br.com.lobolabs.ebalance.feature.expense.ExpenseScreen
import br.com.lobolabs.ebalance.feature.home.HomeScreen
import br.com.lobolabs.ebalance.feature.provider.ProviderScreen
import br.com.lobolabs.ebalance.feature.receiver.ReceiverScreen
import br.com.lobolabs.ebalance.feature.sale.SaleScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(
    navController: NavHostController = rememberNavController()
) {
    AppTheme {
        Scaffold { innerPadding ->
            NavHost(
                modifier = Modifier.padding(innerPadding),
                navController = navController,
                startDestination = ""
            ) {
                composable("home") {
                    HomeScreen()
                }
                composable("sales") {
                    SaleScreen()
                }
                composable("expenses") {
                    ExpenseScreen()
                }
                composable("customers") {
                    CustomerScreen()
                }
                composable("providers") {
                    ProviderScreen()
                }
                composable("receivers") {
                    ReceiverScreen()
                }
            }
        }
    }
}