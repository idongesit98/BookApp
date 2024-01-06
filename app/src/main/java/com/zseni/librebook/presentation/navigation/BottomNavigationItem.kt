package com.zseni.librebook.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

//Initializing the data class with default parameters
 class BottomNavigationItem(
    val label:String = "",
    val icon:ImageVector = Icons.Filled.Home,
    val route:String = ""
){
    // function to get the list of bottomNavigationItems
    fun bottomNavigationItem(): List<BottomNavigationItem>{
        return listOf(
            BottomNavigationItem(
                label = "Home",
                icon = Icons.Filled.Home,
                route = Screen.Home.route
            ),
//            BottomNavigationItem(
//                label = "Details",
//                icon = Icons.Filled.ThumbUp,
//                route = Screen.Details.route
//            ),
            BottomNavigationItem(
                label = "Search",
                icon = Icons.Filled.Search,
                route = Screen.Search.route
            ),
            BottomNavigationItem(
                label = "Category",
                icon = Icons.Filled.LocationOn,
                route = Screen.Category.route
            )
        )
    }

}
