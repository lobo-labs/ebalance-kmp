import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.lobolabs.ebalance.core.presentation.util.AppTheme
import br.com.lobolabs.ebalance.core.presentation.util.navigation.AppScreens
import br.com.lobolabs.ebalance.feature.contract.core.contractModule
import br.com.lobolabs.ebalance.feature.login.core.signInModule
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.core.context.startKoin

@Composable
@Preview
fun App(
    navController: NavHostController = rememberNavController()
) {
    startKoin {
        modules(
            signInModule,
            contractModule
        )
    }

    AppTheme {

        Scaffold { innerPadding ->
            NavHost(
                modifier = Modifier.padding(innerPadding),
                navController = navController,
                startDestination = AppScreens.Launcher().route
            ) {
                composable(AppScreens.Launcher().route) {
                    AppScreens.Launcher().screen
                }
                composable(AppScreens.Home().route) {
                    AppScreens.Home().screen
                }
                composable(AppScreens.Sales().route) {
                    AppScreens.Sales().screen
                }
                composable(AppScreens.Expenses().route) {
                    AppScreens.Sales().screen
                }
                composable(AppScreens.Customers().route) {
                    AppScreens.Customers().screen
                }
                composable(AppScreens.Providers().route) {
                    AppScreens.Providers().screen
                }
                composable(AppScreens.Receivers().route) {
                    AppScreens.Receivers().route
                }
            }
        }
    }
}