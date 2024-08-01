package br.com.lobolabs.ebalance.presentation.ui.component.sale

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.lobolabs.ebalance.R
import br.com.lobolabs.ebalance.presentation.ui.component.image.CardImage
import br.com.lobolabs.ebalance.presentation.ui.component.text.AppSubtitleText
import br.com.lobolabs.ebalance.presentation.ui.util.AppTheme
import domain.sale.Sale
import domain.sale.SaleFactory
import java.text.NumberFormat

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SaleListItem(
    modifier: Modifier = Modifier,
    onItemClick: (Sale) -> Unit,
    isSelected: Boolean = false,
    sale: Sale
) {
    Card(
        backgroundColor = MaterialTheme.colors.background,
        border = BorderStroke(
            width = 2.dp,
            color = MaterialTheme.colors.secondary.takeIf {
                isSelected
            } ?: MaterialTheme.colors.surface
        ),
        elevation = 0.dp,
        shape = RoundedCornerShape(14.dp),
        onClick = { onItemClick(sale) }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            CardImage(
                imageId = R.drawable.ic_cash_in,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    AppSubtitleText(
                        text = "Cliente:",
                        isBold = true,
                        textColor = MaterialTheme.colors.onBackground,
                        modifier = Modifier.padding(end = 8.dp, bottom = 0.dp)
                    )
                    AppSubtitleText(
                        text = sale.customer?.name ?: "Não identificado",
                        textColor = MaterialTheme.colors.onBackground,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 4.dp)
                    )
                }
                sale.receiver?.let { receiver ->
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        AppSubtitleText(
                            text = "Destinatário:",
                            isBold = true,
                            textColor = MaterialTheme.colors.onBackground,
                            modifier = Modifier.padding(end = 8.dp, top = 8.dp)
                        )
                        AppSubtitleText(
                            text = receiver.name,
                            textColor = MaterialTheme.colors.onBackground,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 4.dp, top = 8.dp)
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    AppSubtitleText(
                        text = "Entrada:",
                        isBold = true,
                        textColor = MaterialTheme.colors.onBackground,
                        modifier = Modifier.padding(end = 8.dp, top = 8.dp)
                    )
                    AppSubtitleText(
                        text = sale.entryDate,
                        textColor = MaterialTheme.colors.onBackground,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 4.dp, top = 8.dp)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    AppSubtitleText(
                        text = "Vencimento:",
                        isBold = true,
                        textColor = MaterialTheme.colors.onBackground,
                        modifier = Modifier.padding(end = 8.dp, top = 8.dp)
                    )
                    AppSubtitleText(
                        text = sale.finishDate,
                        textColor = MaterialTheme.colors.onBackground,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 4.dp, top = 8.dp)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    AppSubtitleText(
                        text = "À receber:",
                        isBold = true,
                        textColor = MaterialTheme.colors.secondary,
                        modifier = Modifier.padding(end = 8.dp, top = 8.dp)
                    )
                    AppSubtitleText(
                        text = NumberFormat.getCurrencyInstance().format(sale.toReceive),
                        isBold = true,
                        textColor = MaterialTheme.colors.secondary,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 4.dp, top = 8.dp)
                    )
                }
                if (sale.toReceive != sale.total) {
                    AppSubtitleText(
                        text = "Recebido: ${
                            NumberFormat.getCurrencyInstance().format(sale.cashIn)
                        }",
                        striped = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun SaleListItemPreview() {
    AppTheme {
        SaleListItem(
            sale = SaleFactory.getSale(1L),
            onItemClick = {}
        )
    }
}
