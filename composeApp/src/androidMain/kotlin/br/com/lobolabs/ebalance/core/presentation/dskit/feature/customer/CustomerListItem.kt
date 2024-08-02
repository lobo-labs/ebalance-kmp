package br.com.lobolabs.ebalance.core.presentation.dskit.feature.customer

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.lobolabs.ebalance.R
import br.com.lobolabs.ebalance.core.presentation.dskit.component.image.CardImage
import br.com.lobolabs.ebalance.core.presentation.dskit.component.text.AppSubtitleText
import br.com.lobolabs.ebalance.core.presentation.util.AppTheme
import customer.CustomerFactory
import customer.domain.Customer


@Composable
fun CustomerListItem(
    modifier: Modifier = Modifier,
    onItemClick: (Customer) -> Unit,
    isSelected: Boolean = false,
    customer: Customer
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
        onClick = { onItemClick(customer) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            CardImage(
                imageId = R.drawable.ic_user,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 16.dp)
            ) {
                AppSubtitleText(
                    text = customer.name,
                    isBold = true,
                    textColor = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(end = 8.dp, top = 8.dp)
                )
                AppSubtitleText(
                    text = customer.cnpj ?: "CNPJ não informado",
                    modifier = Modifier.padding(end = 8.dp, top = 4.dp)
                )
            }
        }
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun CustomerListItemPreview() {
    AppTheme {
        CustomerListItem(
            customer = CustomerFactory.getCustomer(1),
            onItemClick = {}
        )
    }
}
