package com.example.cryptotrackerapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cryptotrackerapp.model.Asset

@Composable
fun AssetList()
{
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onBackground)
    ){
        AssetRow(
            Asset(
                id = "bitcoin",
                name="Bitcoin",
                symbol ="BTC",
                price = 65000.0,
                percentage = 5.75
            )
        )
        Divider()
        AssetRow(
            Asset(
                id = "etherum",
                name="Etherum",
                symbol ="ETH",
                price = 3500.0,
                percentage = -1.8
            )
        )
        Divider()
    }
}
@Composable
fun AssetRow(asset: Asset){
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)) {
        //https://assets.coincap.io/assets/icons/btc@2x.png
Box(modifier = Modifier.padding(horizontal = 8.dp)){
if(LocalInspectionMode.current){
    Icon(
      imageVector =  Icons.Filled.AccountCircle,
      contentDescription = null,
    tint = Color.White,
    modifier = Modifier
                .padding(15.dp)
            .size(50.dp)

      )
}else {
    AsyncImage(
        model = "https://assets.coincap.io/assets/icons/${asset.symbol.lowercase()}@2x.png",
        contentDescription = null,
                modifier = Modifier
            .padding(15.dp)
            .size(50.dp)
    )
}
}
        Column {
            Text(asset.name, fontSize = 16.sp, color=Color.White)
            Text(asset.symbol, fontSize = 12.sp, color = Color.Gray)

        }
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "$${asset.price}",
            fontSize = 16.sp,
            modifier = Modifier
                .padding(horizontal = 8.dp)
        )
        Text("${asset.percentage}%",
            color = if(asset.percentage >=0) Color.Green else Color.Red,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(horizontal = 8.dp)
        )

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable

fun AssetRowPreview(){
    AssetList()
}