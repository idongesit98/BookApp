package com.zseni.librebook.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.zseni.librebook.ui.theme.Typography
import com.zseni.librebook.ui.theme.mainText

@Composable
fun BookDetailsCard(
    title: String,
    authors: List<String>,
    thumbnailUrl: String,
    categories: List<String>
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 20.dp, end = 16.dp, bottom = 40.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(color = MaterialTheme.colorScheme.surface),
        )
        BookImageContentView(title, authors, thumbnailUrl, categories)
    }

}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun BookImageContentView(
    title: String,
    authors: List<String>,
    thumbnailUrl: String,
    categories: List<String>
) {
    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(thumbnailUrl)
                .build(),
            contentDescription = title,
            modifier = Modifier
                .size(240.dp, 140.dp).padding(top = 10.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = Typography.displaySmall,
                textAlign = TextAlign.Center,
                color = mainText,
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = authors.toString(),
                style = Typography.displayMedium,
                color = mainText.copy(0.75f),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))

            FlowRow {
                categories.forEach {
                    SubCard(category = it)
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewBookDetails(){
    val detail: List<String> = emptyList()
    val cat: List<String> = emptyList()
    BookDetailsCard("",detail,"",cat)
}