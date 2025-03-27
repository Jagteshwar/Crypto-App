package com.jagteshwar.cryptoapp.presentation.get_coins

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.collect
import okhttp3.internal.wait

@Composable
fun CoinListScreen(modifier: Modifier = Modifier, viewModel: GetCoinsViewModel) {
    val list = viewModel.listState
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        items(list.value){
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = it.id)
                Spacer(modifier = Modifier.width(15.dp))

                Text(text = it.name)
                Spacer(modifier = Modifier.width(15.dp))

                Text(text = it.symbol)

            }
        }

     //   Text(text = "No")
        
    }
}