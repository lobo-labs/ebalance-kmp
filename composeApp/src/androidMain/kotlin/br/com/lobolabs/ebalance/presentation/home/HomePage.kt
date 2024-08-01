package br.com.lobolabs.ebalance.presentation.home

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.lobolabs.ebalance.presentation.ui.component.bottomnav.AppBottomNavigation
import br.com.lobolabs.ebalance.presentation.ui.util.AppTheme
import br.com.lobolabs.ebalance.presentation.ui.util.navigation.NavigationItems
import br.com.lobolabs.ebalance.presentation.ui.util.navigation.NavigationMenus

@Composable
fun HomePage(
//    navigationType: NavigationType,
    selectedItem: NavigationItems,
//    homeUiState: HomeUiState,
    modifier: Modifier = Modifier,
//    onMenuItemClick: (NavigationMenu) -> Unit
) {
    Box(modifier = modifier) {
        Row(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.surface)
            ) {
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
                    navigationItems = NavigationMenus.BottomNavigation().items,
                    onMenuItemPressed = { menu ->

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
fun EbalanceAppContentPreview() {
    AppTheme {
        HomePage(
            selectedItem = NavigationItems.Home()
        )
    }
}
