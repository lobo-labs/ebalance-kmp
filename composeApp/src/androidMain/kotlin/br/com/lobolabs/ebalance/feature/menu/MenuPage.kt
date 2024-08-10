package br.com.lobolabs.ebalance.feature.menu

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.lobolabs.ebalance.R
import br.com.lobolabs.ebalance.core.presentation.dskit.component.card.AppCardOutline
import br.com.lobolabs.ebalance.core.presentation.dskit.component.image.CardImage
import br.com.lobolabs.ebalance.core.presentation.dskit.component.text.AppSubtitleText
import br.com.lobolabs.ebalance.core.presentation.dskit.component.text.AppTitleText
import br.com.lobolabs.ebalance.core.presentation.util.AppTheme
import br.com.lobolabs.ebalance.core.presentation.util.navigation.AppScreens

@Composable
fun MenuPage(
    modifier: Modifier = Modifier,
    navHostController: NavHostController? = null
) {
    Scaffold {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_account),
                        contentDescription = "",
                        modifier = Modifier.padding(12.dp),
                        colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.primary)
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp)
                ) {
                    AppTitleText(text = "LoboLabs")
                    AppSubtitleText(text = "55.315.153/0001-05")
                }
            }

            HorizontalDivider(
                thickness = 2.dp,
                color = MaterialTheme.colorScheme.surface,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
            )

            AppCardOutline(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                isSelected = false,
                onClick = {
                    navHostController?.navigate(AppScreens.Contracts().route)
                }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CardImage(imageId = R.drawable.ic_contract)
                    AppSubtitleText(
                        text = "Contratos",
                        textColor = MaterialTheme.colorScheme.primary,
                        isBold = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp),
                    )
                }
            }

            AppCardOutline(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                isSelected = false,
                onClick = {
                    navHostController?.navigate(AppScreens.Users().route)
                }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CardImage(imageId = R.drawable.ic_user)
                    AppSubtitleText(
                        text = "Usuários",
                        textColor = MaterialTheme.colorScheme.primary,
                        isBold = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp),
                    )
                }
            }

            AppCardOutline(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                isSelected = false,
                onClick = { }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CardImage(imageId = R.drawable.ic_company)
                    AppSubtitleText(
                        text = "Empresas",
                        textColor = MaterialTheme.colorScheme.primary,
                        isBold = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp),
                    )
                }
            }

            AppCardOutline(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                isSelected = false,
                onClick = { }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CardImage(
                        imageId = R.drawable.ic_sign_out,
                        imageColor = MaterialTheme.colorScheme.error
                    )
                    AppSubtitleText(
                        text = "Sair",
                        textColor = MaterialTheme.colorScheme.primary,
                        isBold = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp),
                    )
                }
            }

        }
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun MenuPagePreview() {
    AppTheme {
        MenuPage()
    }
}