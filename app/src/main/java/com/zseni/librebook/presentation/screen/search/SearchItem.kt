package com.zseni.librebook.presentation.screen.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.zseni.librebook.domain.model.Results
import com.zseni.librebook.ui.theme.Typography

@Composable
fun SearchItem(
    result: Results,
    onItemClick:(Results) -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick(result)
            }
            .padding(10.dp)
    ){
        AsyncImage(
            model = result.formats?.image,
            contentDescription = result.formats?.image.toString(),
            modifier = Modifier
                .padding(start = 8.dp)
        )
        Text(
            text = result.title,
            modifier = Modifier
                .padding(5.dp),
            style = Typography.displayMedium
        )

    }

}