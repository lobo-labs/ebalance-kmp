package br.com.lobolabs.ebalance.presentation.ui.component.expense

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.lobolabs.ebalance.R
import br.com.lobolabs.ebalance.presentation.ui.component.text.AppSubtitleText
import br.com.lobolabs.ebalance.presentation.ui.util.AppTheme
import domain.sale.Sale
import domain.sale.SaleFactory
import java.text.NumberFormat

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpenseListItem(
    modifier: Modifier = Modifier,
    onItemClick: (Sale) -> Unit,
    isSelected: Boolean = false,
    expense: Sale
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
        onClick = { onItemClick(expense) }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Card(
                modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                shape = RoundedCornerShape(10.dp),
                backgroundColor = MaterialTheme.colors.surface,
                elevation = 0.dp
            ) {
                Image(
                    modifier = Modifier.padding(14.dp),
                    painter = painterResource(id = R.drawable.ic_cash_in),
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colors.secondary),
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
                        textColor = MaterialTheme.colors.onBackground,
                        modifier = Modifier.padding(
                            start = 8.dp,
                            end = 8.dp,
                            top = 8.dp,
                            bottom = 0.dp
                        )
                    )
                    AppSubtitleText(
                        text = expense.customer?.name ?: "Não identificado",
                        textColor = MaterialTheme.colors.onBackground,
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
                            textColor = MaterialTheme.colors.onBackground,
                            modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp)
                        )
                        AppSubtitleText(
                            text = receiver.name,
                            textColor = MaterialTheme.colors.onBackground,
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
                        textColor = MaterialTheme.colors.onBackground,
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp)
                    )
                    AppSubtitleText(
                        text = expense.entryDate,
                        textColor = MaterialTheme.colors.onBackground,
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
                        textColor = MaterialTheme.colors.onBackground,
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp)
                    )
                    AppSubtitleText(
                        text = expense.finishDate,
                        textColor = MaterialTheme.colors.onBackground,
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
                        textColor = MaterialTheme.colors.secondary,
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp)
                    )
                    AppSubtitleText(
                        text = NumberFormat.getCurrencyInstance().format(expense.toReceive),
                        isBold = true,
                        textColor = MaterialTheme.colors.secondary,
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
