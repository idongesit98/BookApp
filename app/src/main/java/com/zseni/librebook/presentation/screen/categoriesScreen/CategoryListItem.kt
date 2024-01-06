package com.zseni.librebook.presentation.screen.categoriesScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.zseni.librebook.R
import com.zseni.librebook.domain.model.Results

@Composable
fun CategoryListItem(
    result:Results,
    onItemClick:(Results)-> Unit
){
    Card {
        Column(
            modifier = Modifier
                .width(100.dp)
                .height(200.dp)
                .clickable { onItemClick(result) }
        ) {
            AsyncImage(
                modifier = Modifier.size(100.dp) ,
                model = result.formats?.image,
                contentDescription = stringResource(id = R.string.book_img)
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = result.title,
                fontSize = 10.sp,
                textAlign = TextAlign.Center,
                letterSpacing = 0.1.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = result.authors.firstOrNull()?.name.toString(),
                fontSize = 10.sp,
                textAlign = TextAlign.Center,
                letterSpacing = 0.01.sp,
                overflow = TextOverflow.Ellipsis

            )
        }
    }

}
