package br.com.lobolabs.ebalance.presentation.ui.component.bottomnav

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.lobolabs.ebalance.presentation.ui.util.AppTheme
import br.com.lobolabs.ebalance.presentation.ui.util.navigation.NavigationItems
import br.com.lobolabs.ebalance.presentation.ui.util.navigation.NavigationMenus

@Composable
fun AppBottomNavigation(
    navigationItems: List<NavigationItems>,
    selectedMenuItem: NavigationItems,
    onMenuItemPressed: ((NavigationItems) -> Unit),
    modifier: Modifier = Modifier
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        modifier = modifier
    ) {
        for (navMenu in navigationItems) {
            BottomNavigationItem(
                selectedContentColor = MaterialTheme.colors.secondary,
                unselectedContentColor = MaterialTheme.colors.onBackground,
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

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun AppBottomNavigationPreview() {
    AppTheme {
        AppBottomNavigation(
            selectedMenuItem = NavigationItems.Home(),
            navigationItems = NavigationMenus.BottomNavigation().items,
            onMenuItemPressed = {}
        )
    }
}
