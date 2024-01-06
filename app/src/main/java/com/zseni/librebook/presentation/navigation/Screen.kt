package com.zseni.librebook.presentation.navigation

import androidx.annotation.StringRes
import com.zseni.librebook.R

/**
 * This sealed class give a title,active/inactive icon to the bottom navigation bar
 * it is used in the home screen for the bottom navigation
 * it also contains the label and icons for the different destinations on the bottom nav bar
 */
sealed class Screen(val route:String){
    data object Details: Screen("details_route")
    data object Home: Screen("home_route")
    data object Search: Screen("search_route")
    data object Category: Screen("category_screen")
}

sealed class TabItem(val tabTitle: String)

data class AllTab(val title:String): TabItem(title)
data class PopularTab(val title: String): TabItem(title)
data class RecentTab(val title: String): TabItem(title)
data class TrendingTab(val title: String): TabItem(title)
data class BestSellingTab(val title: String): TabItem(title)



