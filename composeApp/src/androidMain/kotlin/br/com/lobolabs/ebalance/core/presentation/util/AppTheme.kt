package br.com.lobolabs.ebalance.core.presentation.util

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val darkColorScheme = darkColorScheme(
    primary = AppColors.Common.White,
    onPrimary = AppColors.Green.Dark,
    secondary = AppColors.Green.Color,
    onSecondary = AppColors.Common.White,
    background = AppColors.Green.Dark,
    onBackground = AppColors.Common.White,
    surface = AppColors.Gray.Darkest,
    onSurface = AppColors.Gray.Dark,
    error = AppColors.Common.Red,
    onError = AppColors.Common.White
)

private val lightColorScheme = lightColorScheme(
    primary = AppColors.Green.Dark,
    onPrimary = AppColors.Common.White,
    secondary = AppColors.Green.Color,
    onSecondary = AppColors.Common.White,
    background = AppColors.Common.White,
    onBackground = AppColors.Gray.Light,
    surface = AppColors.Gray.Color,
    onSurface = AppColors.Gray.Dark,
    error = AppColors.Common.Red,
    onError = AppColors.Common.White
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
        darkTheme -> darkColorScheme
        else -> lightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
//         typography = Typography(
//             defaultFontFamily = FontFamily(Font(resId = R.font.nexa))
//         ),
        content = content
    )
}
