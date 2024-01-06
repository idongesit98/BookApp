package com.zseni.librebook.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zseni.librebook.data.room.assetModel.BooksItem
import com.zseni.librebook.presentation.navigation.Screen

@Composable
fun PopularTabs(title:String){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        Text(
            text = "Popular Tab $title" )

    }
}

@Composable
fun RecentTabs(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        Text(
            text = "Recent Tab" )
    }
}

@Composable
fun TrendingTabs(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        Text(
            text = "Trending Tab" )
    }
}

@Composable
fun BestSellingTabs(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        Text(
            text = "Best Selling Tab" )
    }
}



