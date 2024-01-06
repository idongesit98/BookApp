package com.zseni.librebook.presentation.screen.categoriesScreen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zseni.librebook.R
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.zseni.librebook.presentation.viewmodel.CategoryViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(
    navController: NavController,
    viewModel: CategoryViewModel = hiltViewModel()
){
    val state = viewModel.uiState.collectAsState().value
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.cat_name))
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Transparent,
                    titleContentColor = Color.Black
                )
            )

        },
        content = {

            Column(modifier = Modifier.fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(25.dp))
                Box(
                    modifier = Modifier.fillMaxSize()){
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(
                            horizontal = 16.dp, vertical = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ){
                        item {
                            Text(
                                text = stringResource(id = R.string.popular),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold,
                                modifier = Modifier.padding(8.dp)
                            )
                            LazyRow(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                content = {
                                    items(state.popularBooks){ result ->
                                        CategoryListItem(
                                            result = result
                                        ){
                                            //navController.navigate fix the navigation
                                        }
                                    }
                                }
                            )
                        }

                        item {
                            Text(
                                text = stringResource(id = R.string.biography),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold,
                                modifier = Modifier.padding(8.dp)
                            )
                            LazyRow(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                content = {
                                    items(state.biographyBooks){ result ->
                                        Log.i("bioBooks", "Biography:${state.biographyBooks}")
                                        CategoryListItem(
                                            result = result
                                        ){
                                            //fix the navigation
                                        }
                                    }
                                }
                            )
                        }
                        item {
                            Text(
                                text = stringResource(id = R.string.children),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold,
                                modifier = Modifier.padding(8.dp)
                            )
                            LazyRow(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                content = {
                                    items(state.childrenBooks){ result ->
                                        Log.i("childrenBooks", "Children:${state.childrenBooks}")
                                      CategoryListItem(
                                          result = result
                                      ) {
                                        //Fix the navigation problem
                                      }
                                    }
                                }
                            )
                        }
                        
                        item {
                            Text(
                                text = stringResource(id = R.string.english),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold,
                                modifier = Modifier.padding(8.dp)
                            )
                            LazyRow(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                content = {
                                    items(state.englishBooks){ result ->
                                        CategoryListItem(
                                            result = result,
                                        ){
                                            //Navigation
                                        }
                                    }
                                }
                            )
                        }

                        item {
                            Text(
                                text = stringResource(id = R.string.children),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold,
                                modifier = Modifier.padding(8.dp)
                            )
                            LazyRow(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                content = {
                                    items(state.childrenBooks){ result ->
                                        CategoryListItem(
                                            result = result,
                                        ){
                                            //Navigation
                                        }
                                    }
                                }
                            )
                        }

                        item {
                            Text(
                                text = stringResource(id = R.string.war),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold,
                                modifier = Modifier.padding(8.dp)
                            )
                            LazyRow(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                content = {
                                    items(state.warBooks){ result ->
                                        CategoryListItem(
                                            result = result,
                                        ){
                                            //Navigation
                                        }
                                    }
                                }
                            )
                        }

                        item {
                            Text(
                                text = stringResource(id = R.string.french_finnish),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold,
                                modifier = Modifier.padding(8.dp)
                            )
                            LazyRow(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                content = {
                                    items(state.frenchorFinish){ result ->
                                        CategoryListItem(
                                            result = result,
                                        ){
                                            //Navigation wahala has not been fixed
                                        }
                                    }
                                }
                            )
                        }
                        item {
                            Text(
                                text = stringResource(id = R.string.geology),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold,
                                modifier = Modifier.padding(8.dp)
                            )
                            LazyRow(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                content = {
                                    items(state.geologyBooks){ result ->
                                        CategoryListItem(
                                            result = result,
                                        ){
//FIX THE NAVIGATION PROBLEMS
                                        }
                                    }
                                }
                            )
                        }
                        item {
                            Text(
                                text = stringResource(id = R.string.history),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold,
                                modifier = Modifier.padding(8.dp)
                            )
                            LazyRow(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                content = {
                                    items(state.historyBooks){ result ->
                                        CategoryListItem(
                                            result = result,
                                        ){
                                            //Navigation Issues
                                        }
                                    }
                                }
                            )
                        }

                        item {
                            Text(
                                text = stringResource(id = R.string.law),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold,
                                modifier = Modifier.padding(8.dp)
                            )
                            LazyRow(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                content = {
                                    items(state.lawBooks){ result ->
                                        CategoryListItem(
                                            result = result,
                                        ){
                                            //NAVIGATION ISSUES
                                        }
                                    }
                                }
                            )
                        }

                        item {
                            Text(
                                text = stringResource(id = R.string.mystery),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold,
                                modifier = Modifier.padding(8.dp)
                            )
                            LazyRow(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                content = {
                                    items(state.mysteryBooks){ result ->
                                        CategoryListItem(
                                            result = result,
                                        ){
                                            //Navigation issues
                                        }
                                    }
                                }
                            )
                        }
                        item {
                            Text(
                                text = stringResource(id = R.string.science),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold,
                                modifier = Modifier.padding(8.dp)
                            )
                            LazyRow(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                content = {
                                    items(state.scienceBooks){ result ->
                                        CategoryListItem(
                                            result = result,
                                        ){

                                        }
                                    }
                                }
                            )
                        }
                        item {
                            Text(
                                text = stringResource(id = R.string.spanish),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold,
                                modifier = Modifier.padding(8.dp)
                            )
                            LazyRow(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                content = {
                                    items(state.spanishBook){ result ->
                                        CategoryListItem(
                                            result = result,
                                        ){

                                        }
                                    }
                                }
                            )
                        }

                    }
                }
            }

        }
    )

}

@Preview
@Composable
fun PreviewCategory(){
    val navController = rememberNavController()

    CategoryScreen(navController = navController)
}