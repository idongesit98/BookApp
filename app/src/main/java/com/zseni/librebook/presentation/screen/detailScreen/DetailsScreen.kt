package com.zseni.librebook.presentation.screen.detailScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.zseni.librebook.R
import com.zseni.librebook.presentation.components.BookDetailsCard
import com.zseni.librebook.presentation.components.TopBar
import com.zseni.librebook.presentation.viewmodel.MainViewModel
import com.zseni.librebook.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Details(viewModel:MainViewModel, navController: NavController){
    Scaffold(
        topBar = {
            TopBar(
                title = stringResource(id = R.string.book_details),navController
                )
        }){ innerPadding ->
        BookDetails(viewModel = viewModel, modifier = Modifier.padding(innerPadding))

    }
}

@Composable
fun BookDetails(viewModel: MainViewModel,modifier: Modifier){
    val result = viewModel.uiDetailState.collectAsState()
    when(val viewState = result.value){
        is DetailViewState.Error -> Text("Error found: ${viewState.exception}")
        DetailViewState.Loading -> Text("Loading")
        is DetailViewState.Success -> {
            LazyColumn {
                val book = viewState.data
                item {
                    BookDetailsCard(book.title, book.authors, book.thumbnailUrl, book.categories)
                }
                //Description
                item {
                    Text(
                        text = stringResource(id = R.string.book_details),
                        style = Typography.displaySmall,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = modifier.padding(start = 10.dp, end = 20.dp)
                    )
                }
                item {
                    Text(
                        text = book.longDescription,
                        style = Typography.displayMedium,
                        textAlign = TextAlign.Justify,
                        color = Color.Black,
                        modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                    )
                }

            }
        }
        DetailViewState.Empty -> Text("No results found")

    }

}