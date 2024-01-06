package com.zseni.librebook.presentation.screen.homeScreen

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.zseni.librebook.R
import com.zseni.librebook.data.room.assetModel.BooksItem
import com.zseni.librebook.presentation.navigation.AllTab
import com.zseni.librebook.presentation.navigation.BestSellingTab
import com.zseni.librebook.presentation.navigation.BottomNavigationItem
import com.zseni.librebook.presentation.navigation.MainAction
import com.zseni.librebook.presentation.navigation.PopularTab
import com.zseni.librebook.presentation.navigation.RecentTab
import com.zseni.librebook.presentation.navigation.Screen
import com.zseni.librebook.presentation.navigation.TrendingTab
import com.zseni.librebook.presentation.components.ItemBookList
import com.zseni.librebook.presentation.util.imgList
import com.zseni.librebook.presentation.viewmodel.MainViewModel
import com.zseni.librebook.ui.theme.Gelasio
import com.zseni.librebook.ui.theme.Typography
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

/**
 * TODO: val result = viewModel.uiState.value will return an error in a
 *  composable because in composition you be listening to events not just reading
 * the current one your view wont get recomposed after the value is changed
 *
 */

@Composable
fun HomeScreen(viewModel:MainViewModel, actions: MainAction, navController: NavController){
    val result = viewModel.uiState.collectAsState()
    when(val viewState = result.value){
        ViewState.Empty -> Text("No results found")
        is ViewState.Error -> Text("Error found: ${viewState.exception}")
        ViewState.Loading -> Text("Loading")
        is ViewState.Success -> {
            HomeList( viewState.data, actions,navController)
            //when trying to use UseCases attempt result.value.data in the viewModel section
        }
    }

}
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeList(bookList: List<BooksItem>, actions: MainAction, navController:NavController) {

    val tabItem = listOf(
        AllTab("All"),
        PopularTab("Popular"),
        RecentTab("Recent"),
        TrendingTab("Trending"),
        BestSellingTab("Best-Selling")
    )
    val search = remember{mutableStateOf("")}

    val pagerState = rememberPagerState(
        initialPage = 2,
        initialPageOffsetFraction = 0.25f
    ) { // provide pageCount
        imgList.size
    }

    var navigationSelectedItem by remember {
        mutableIntStateOf(0)
    }
    val tabState = rememberPagerState {tabItem.size}
    LaunchedEffect(Unit){
        while (true){
            yield()
            delay(1000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount),
                animationSpec = tween(600)
            )
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
            title = { Text(text = stringResource(id = R.string.bar_name),
                fontFamily = Gelasio,
                fontSize = 25.sp) },
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.github),
                        contentDescription = stringResource(id = R.string.icon_name))
                }
            }
        )},
        bottomBar = {
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                NavigationBar {
                    BottomNavigationItem().bottomNavigationItem().forEachIndexed{
                            index, navigationItem ->
                        NavigationBarItem(
                            selected = index == navigationSelectedItem,
                            label = {Text(navigationItem.label)},
                            onClick = {
                                navigationSelectedItem = index
                                navController.navigate(navigationItem.route){
                                    popUpTo(navController.graph.findStartDestination().id){
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }},
                            icon = {
                                Icon(
                                    navigationItem.icon,
                                    contentDescription = navigationItem.label
                                )
                            }
                        )
                    }
                }
            }

        }
    ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .height(140.dp)
                ) { page ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 2.dp
                        )
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterHorizontally)
                                .background(Color.White)
                                .padding(5.dp)

                        ) {
                            val page = imgList[page]
                            Image(
                                painter = painterResource(id = page.imgUri),
                                contentDescription = stringResource(id = R.string.paging_img),
                                contentScale = ContentScale.Inside,
                                modifier = Modifier
                                    .wrapContentSize()
                                    .clip(RoundedCornerShape(10.dp))
                                    .align(Alignment.Center),
                                alignment = Alignment.Center
                            )
                        }
                    }
                }

            var selectedTabIndex by remember { mutableIntStateOf(0) }
            LaunchedEffect(selectedTabIndex){
                tabState.animateScrollToPage(selectedTabIndex)
            }
            LaunchedEffect(tabState.currentPage, tabState.isScrollInProgress){
                if (!tabState.isScrollInProgress) {
                    selectedTabIndex = tabState.currentPage
                }
            }
            ScrollableTabRow(
                    selectedTabIndex = selectedTabIndex,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    indicator = {tabPositions ->
                        TabRowDefaults.Indicator(
                            modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex])
                        )
                    }
                ) {
                    tabItem.forEachIndexed { index, item ->
                        Tab(
                            selected = index == selectedTabIndex,
                            onClick = { selectedTabIndex = index },
                            text = {
                                Text(
                                    text = item.tabTitle,
                                    style = Typography.labelSmall,
                                    maxLines = 1
                                )
                            }
                        )
                    }
                }
                HorizontalPager(
                    state = tabState,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    LazyColumn {
                          items(bookList.filter { it.title.contains(search.value, ignoreCase = true) })
                          { book ->
                              ItemBookList(
                                  book.title,
                                  book.authors.toString(),
                                  book.thumbnailUrl,
                                  book.categories,
                                  onItemClick = {
                                      //actions.gotoBookDetails.invoke()
                                      navController.navigate(Screen.Details.route + "/${book.isbn}")
                                  }
                              )
                          }
                    }
            }
        }
    }
}

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



@Preview
@Composable
fun PreviewHome(){
    val navController = rememberNavController()
    val previewAction = MainAction(navController)
    val bookList: List<BooksItem> = emptyList()

    HomeList(bookList = bookList, previewAction, navController)
}

