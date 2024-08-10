package br.com.lobolabs.ebalance.feature.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
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
import br.com.lobolabs.ebalance.core.presentation.dskit.component.card.AppCardPrimary
import br.com.lobolabs.ebalance.core.presentation.dskit.component.filter.AppFilter
import br.com.lobolabs.ebalance.core.presentation.dskit.component.image.CardImage
import br.com.lobolabs.ebalance.core.presentation.dskit.component.text.AppSubtitleText
import br.com.lobolabs.ebalance.core.presentation.dskit.component.text.AppTitleText
import br.com.lobolabs.ebalance.core.presentation.util.AppTheme

@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    navController: NavHostController? = null
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column {
                AppTitleText(text = "Resumo")
                AppSubtitleText(text = "Seu resumo financeiro")
            }
            AppFilter(text = "Semanal") {

            }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            AppCardOutline(
                modifier = Modifier
                    .weight(1f),
                isSelected = false,
                onClick = { /*TODO*/ }
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CardImage(
                        imageId = R.drawable.ic_cash_in
                    )
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        AppSubtitleText(text = "Receitas")
                        AppSubtitleText(
                            text = "R$ 5.000,00",
                            isBold = true,
                            textColor = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }

            AppCardOutline(
                modifier = Modifier
                    .weight(1f),
                isSelected = false,
                onClick = { /*TODO*/ }
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CardImage(
                        imageId = R.drawable.ic_cash_out,
                        imageColor = MaterialTheme.colorScheme.error
                    )
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        AppSubtitleText(text = "Despesas")
                        AppSubtitleText(
                            text = "R$ 5.000,00",
                            isBold = true,
                            textColor = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }

        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 8.dp)
        ) {
            AppCardOutline(
                modifier = Modifier
                    .weight(1f),
                isSelected = false,
                onClick = { /*TODO*/ }
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CardImage(
                        imageId = R.drawable.ic_cash_in
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        AppSubtitleText(
                            text = "A Receber",
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        AppSubtitleText(
                            text = "R$ 5.000,00",
                            isBold = true,
                            textColor = MaterialTheme.colorScheme.primary,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
                }
            }

            AppCardOutline(
                modifier = Modifier
                    .weight(1f),
                isSelected = false,
                onClick = { /*TODO*/ }
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CardImage(
                        imageId = R.drawable.ic_cash_out,
                        imageColor = MaterialTheme.colorScheme.error
                    )
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        AppSubtitleText(
                            text = "A Pagar",
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        AppSubtitleText(
                            text = "R$ 5.000,00",
                            isBold = true,
                            textColor = MaterialTheme.colorScheme.primary,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
                }
            }

        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 8.dp)
        ) {
            AppCardOutline(
                modifier = Modifier
                    .weight(1f),
                isSelected = false,
                onClick = { /*TODO*/ }
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CardImage(
                        imageId = R.drawable.ic_cash_in
                    )
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        AppSubtitleText(text = "Saldo")
                        AppSubtitleText(
                            text = "R$ 5.000,00",
                            isBold = true,
                            textColor = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }

            AppCardOutline(
                modifier = Modifier
                    .weight(1f),
                isSelected = false,
                onClick = { /*TODO*/ }
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CardImage(imageId = R.drawable.ic_cash_in)
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        AppSubtitleText(text = "Saldo Bruto")
                        AppSubtitleText(
                            text = "R$ 5.000,00",
                            isBold = true,
                            textColor = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }

        }

        AppTitleText(
            modifier = Modifier.padding(16.dp),
            text = "Ações rápidas"
        )

        Row(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            AppCardPrimary(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .height(120.dp)
                    .aspectRatio(1.2f),
                onClick = {}
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_add_square),
                        colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onPrimary),
                        contentDescription = "",
                        modifier = Modifier.size(32.dp)
                    )
                    AppSubtitleText(
                        text = "Adicionar<br>Novo item",
                        isBold = true,
                        textColor = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.padding(top = 16.dp),
                    )
                }
            }

            AppCardOutline(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .height(120.dp)
                    .aspectRatio(1.3f),
                isSelected = false,
                onClick = {}
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_person),
                        colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.secondary),
                        contentDescription = "",
                        modifier = Modifier.size(32.dp)
                    )
                    AppSubtitleText(
                        text = "Gerenciar<br>Clientes",
                        isBold = true,
                        textColor = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(top = 16.dp),
                    )
                }
            }

            AppCardOutline(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .height(120.dp)
                    .aspectRatio(1.3f),
                isSelected = false,
                onClick = {}
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_group),
                        colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.secondary),
                        contentDescription = "",
                        modifier = Modifier.size(32.dp)
                    )
                    AppSubtitleText(
                        text = "Gerenciar<br>Destinatários",
                        isBold = true,
                        textColor = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(top = 16.dp),
                    )
                }
            }
        }
        AppTitleText(
            modifier = Modifier.padding(16.dp),
            text = "Movimentações"
        )
    }
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun HomePagePreview() {
    AppTheme {
        HomePage()
    }
}