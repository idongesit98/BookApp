package com.zseni.librebook.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.zseni.librebook.R
import coil.request.ImageRequest
import com.zseni.librebook.ui.theme.Typography
import com.zseni.librebook.ui.theme.mainText
import com.zseni.librebook.ui.theme.primary

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ItemBookList(
    title: String, author: String, thumbnailUrl: String,
    categories: List<String>, onItemClick: () -> Unit) {
    Card(modifier = Modifier
        .clickable(onClick = onItemClick)
        .fillMaxWidth()
        .wrapContentHeight()
        .clip(RoundedCornerShape(16.dp))
        .padding(16.dp)
    ){
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically) {
            //Image
            AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                .data(thumbnailUrl)
                .build(),
                contentDescription = stringResource(id = R.string.book_img),
                modifier = Modifier.size(90.dp,145.dp).padding(start = 10.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))

            //Text Content
            Column {
                Text(text = title, style = Typography.displaySmall,
                    color = mainText)
                Spacer(modifier = Modifier.height(12.dp))

                Text(text = author, style = Typography.displaySmall, color = mainText.copy(0.75f),
                    textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(8.dp))

                FlowRow {
                    categories.forEach {
                        SubCard(category = it)
                    }
                }
            }
        }
    }
}

@Composable
fun SubCard(category: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .padding(start = 12.dp, end = 12.dp, top = 5.dp, bottom = 5.dp),
        contentAlignment = Alignment.Center) {
        Text(
            text = category,
            style = Typography.labelSmall,
            color = primary,
            textAlign = TextAlign.Center
        )

    }
}

@Preview
@Composable
fun PreviewItemBook(){
    val cat:List<String> = emptyList()
    ItemBookList("","","",cat, onItemClick = {})
}