package br.com.lobolabs.ebalance.feature.container

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.lobolabs.ebalance.core.presentation.dskit.component.bottomnav.AppBottomNavigation
import br.com.lobolabs.ebalance.core.presentation.dskit.component.header.AppHeader
import br.com.lobolabs.ebalance.core.presentation.util.AppTheme
import br.com.lobolabs.ebalance.core.presentation.util.navigation.AppScreens
import br.com.lobolabs.ebalance.core.presentation.util.navigation.AppRoutes
import br.com.lobolabs.ebalance.feature.home.HomePage

@Composable
fun ContainerPage(
    selectedItem: AppScreens,
    modifier: Modifier = Modifier,
    navController: NavHostController? = null,
) {
    val containerScreens = listOf(
        HomePage(),
    )
    Box(modifier = modifier) {
        Row(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
            ) {
                AppHeader()
                Column(
//                    homeUiState = homeUiState,
//                    onListItemPressed = { },
//                    onMenuItemPressed = { menu ->
//                        onMenuItemClick(menu)
//                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 16.dp)
                ) {

                }

                AppBottomNavigation(
                    selectedMenuItem = selectedItem,
                    navigationItems = AppRoutes.BottomNavigation().items,
                    onMenuItemPressed = {

                    },
                    modifier = Modifier.fillMaxWidth()
                )

            }
        }
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun ContainerPagePreview() {
    AppTheme {
        ContainerPage(
            selectedItem = AppScreens.Home()
        )
    }
}
