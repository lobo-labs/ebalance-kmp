package br.com.lobolabs.ebalance.core.presentation.dskit.feature.expense

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.lobolabs.ebalance.R
import br.com.lobolabs.ebalance.core.presentation.dskit.component.text.AppSubtitleText
import br.com.lobolabs.ebalance.core.presentation.util.AppTheme
import sale.SaleFactory
import sale.domain.Sale
import java.text.NumberFormat


@Composable
fun ExpenseListItem(
    modifier: Modifier = Modifier,
    onItemClick: (Sale) -> Unit,
    isSelected: Boolean = false,
    expense: Sale
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
        border = BorderStroke(
            width = 2.dp,
            color = MaterialTheme.colorScheme.secondary.takeIf {
                isSelected
            } ?: MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(0.dp),
        shape = RoundedCornerShape(14.dp),
        onClick = { onItemClick(expense) }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Card(
                modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                shape = RoundedCornerShape(10.dp),

                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(0.dp)
            ) {
                Image(
                    modifier = Modifier.padding(14.dp),
                    painter = painterResource(id = R.drawable.ic_cash_in),
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.secondary),
                    contentDescription = ""
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    AppSubtitleText(
                        text = "Cliente:",
                        isBold = true,
                        textColor = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.padding(
                            start = 8.dp,
                            end = 8.dp,
                            top = 8.dp,
                            bottom = 0.dp
                        )
                    )
                    AppSubtitleText(
                        text = expense.customer?.name ?: "Não identificado",
                        textColor = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 4.dp, end = 8.dp, top = 8.dp)
                    )
                }
                expense.receiver?.let { receiver ->
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        AppSubtitleText(
                            text = "Destinatário:",
                            isBold = true,
                            textColor = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp)
                        )
                        AppSubtitleText(
                            text = receiver.name,
                            textColor = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 4.dp, end = 8.dp, top = 8.dp)
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    AppSubtitleText(
                        text = "Entrada:",
                        isBold = true,
                        textColor = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp)
                    )
                    AppSubtitleText(
                        text = expense.entryDate,
                        textColor = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 4.dp, end = 8.dp, top = 8.dp)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    AppSubtitleText(
                        text = "Vencimento:",
                        isBold = true,
                        textColor = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp)
                    )
                    AppSubtitleText(
                        text = expense.finishDate,
                        textColor = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 4.dp, end = 8.dp, top = 8.dp)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    AppSubtitleText(
                        text = "À receber:",
                        isBold = true,
                        textColor = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp)
                    )
                    AppSubtitleText(
                        text = NumberFormat.getCurrencyInstance().format(expense.toReceive),
                        isBold = true,
                        textColor = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 4.dp, end = 8.dp, top = 8.dp)
                    )
                }
                if (expense.toReceive != expense.total) {
                    AppSubtitleText(
                        text = "Recebido: ${
                            NumberFormat.getCurrencyInstance().format(expense.cashIn)
                        }",
                        striped = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, end = 8.dp, top = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun ExpenseListItemPreview() {
    AppTheme {
        ExpenseListItem(
            expense = SaleFactory.getSale(1L),
            onItemClick = {}
        )
    }
}
