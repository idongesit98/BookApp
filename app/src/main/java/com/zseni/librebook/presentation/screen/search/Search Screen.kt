package com.zseni.librebook.presentation.screen.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.zseni.librebook.R
import com.zseni.librebook.presentation.navigation.Screen
import com.zseni.librebook.presentation.viewmodel.SearchViewModel
import com.zseni.librebook.ui.theme.Typography
import com.zseni.librebook.ui.theme.mainText
import com.zseni.librebook.ui.theme.shadowText

@Composable
fun SearchScreen(
    navController: NavController,
    viewModel:SearchViewModel = hiltViewModel()
){
    val searchState = viewModel.searchState.collectAsState().value
    
    Column {
        SearchBar(
            hint = stringResource(id = R.string.search),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        {
            viewModel.search(it)
        }
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            items(searchState.books){ result ->
                SearchItem(
                    result = result,
                    onItemClick = {
                    navController.navigate(Screen.Details.route + "/${it.id}")
                     }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint:String = "",
    onSearch: (String) -> Unit = {}
){
    var text by remember{ mutableStateOf("") }
    val isHintDisplayed by remember{ mutableStateOf(hint != "") }
    
    Box(modifier = modifier){
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color.Transparent
                )
                .padding(
                    horizontal = 12.dp,
                    vertical = 12.dp
                ),
            value = text,
            onValueChange = {
                text = it
                onSearch(it)},
            textStyle = Typography.bodyMedium,
            colors = TextFieldDefaults.textFieldColors(
                textColor = mainText,
                focusedLabelColor = MaterialTheme.colorScheme.primary,
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = Color.LightGray,
                cursorColor = MaterialTheme.colorScheme.primary,
                placeholderColor = shadowText,
                disabledPlaceholderColor = Color.White
            ) ,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            maxLines = 1,
            singleLine = true,
            label = { Text("Search books")}

        )
//        if (isHintDisplayed){
//            Text(
//                text = hint,
//                color = Color.LightGray,
//                modifier = Modifier.padding(
//                    horizontal = 20.dp,
//                    vertical = 12.dp
//                )
//            )
//        }
    }
}

@Preview
@Composable
fun PreviewSearchScreen(){
    val navController = rememberNavController()
    SearchScreen(navController = navController)
}