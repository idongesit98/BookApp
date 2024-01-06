package com.zseni.librebook.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.zseni.librebook.presentation.screen.categoriesScreen.CategoryScreen
import com.zseni.librebook.presentation.screen.detailScreen.Details
import com.zseni.librebook.presentation.screen.homeScreen.HomeScreen
import com.zseni.librebook.presentation.screen.search.SearchScreen
import com.zseni.librebook.presentation.viewmodel.MainViewModel

object EndPoints {
    const val ID = "id"
}
@Composable
fun Navigation(){
    val navController = rememberNavController()
    BottomNavGraph(navController = navController)
}


//TODO:Watch the explanation of the navigation process
@Composable
fun BottomNavGraph(navController: NavHostController) {
    
    val actions = remember(navController) { MainAction(navController) }
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route) {
        //Home
        composable(route = Screen.Home.route) {
            val viewModel: MainViewModel = viewModel(
                factory = HiltViewModelFactory(LocalContext.current, it)
            )
            viewModel.getAllBooks(context = context)
            HomeScreen(viewModel, actions, navController)
        }
        // Task Details
        composable(
            route = "${Screen.Details.route}/{id}",
            arguments = listOf(navArgument(EndPoints.ID){type = NavType.StringType})
        ){
            val viewModel = hiltViewModel<MainViewModel>(it)
            val isbnNo = it.arguments?.getString("id")
                ?:throw IllegalStateException("Book ISBN is not null")
            viewModel.getBooksById(context = context, isbnNo)
            Details(viewModel = viewModel(), navController)
        }

        composable(Screen.Search.route){
            SearchScreen(navController)
        }
        composable(Screen.Category.route){
            CategoryScreen(navController = navController)
        }
    }
}

class MainAction(navController: NavController) {
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
    val gotoBookDetails: () -> Unit = {
        navController.navigate(Screen.Details.route)//"${Screen.Details.route}/isbnNo"
    }

    val goToBookList: () -> Unit = {
        navController.navigate(Screen.Home.route)
    }
}