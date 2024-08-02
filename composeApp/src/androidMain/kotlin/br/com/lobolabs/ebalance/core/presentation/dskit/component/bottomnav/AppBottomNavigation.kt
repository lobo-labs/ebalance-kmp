package br.com.lobolabs.ebalance.core.presentation.dskit.component.bottomnav

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.lobolabs.ebalance.core.presentation.util.AppTheme
import br.com.lobolabs.ebalance.core.presentation.util.navigation.AppRoutes
import br.com.lobolabs.ebalance.core.presentation.util.navigation.AppScreens

@Composable
fun AppBottomNavigation(
    navigationItems: List<AppScreens>,
    selectedMenuItem: AppScreens,
    onMenuItemPressed: ((AppScreens) -> Unit),
    modifier: Modifier = Modifier
) {
    Column {
        HorizontalDivider(color = MaterialTheme.colorScheme.surface)
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.background,
            modifier = modifier
        ) {
            for (navMenu in navigationItems) {
                NavigationBarItem(
                    colors = NavigationBarItemColors(
                        selectedIconColor = MaterialTheme.colorScheme.onSecondary,
                        selectedTextColor = MaterialTheme.colorScheme.onSecondary,
                        unselectedIconColor = MaterialTheme.colorScheme.onBackground,
                        unselectedTextColor = MaterialTheme.colorScheme.onBackground,
                        disabledIconColor = MaterialTheme.colorScheme.onBackground,
                        disabledTextColor = MaterialTheme.colorScheme.onBackground,
                        selectedIndicatorColor = MaterialTheme.colorScheme.secondary
                    ),
                    selected = selectedMenuItem == navMenu,
                    onClick = { onMenuItemPressed(navMenu) },
                    icon = {
                        Icon(
                            painter = painterResource(id = navMenu.icon),
                            contentDescription = stringResource(id = navMenu.label)
                        )
                    }
                )
            }
        }
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun AppBottomNavigationPreview() {
    AppTheme {
        AppBottomNavigation(
            selectedMenuItem = AppScreens.Home(),
            navigationItems = AppRoutes.BottomNavigation().items,
            onMenuItemPressed = {}
        )
    }
}
