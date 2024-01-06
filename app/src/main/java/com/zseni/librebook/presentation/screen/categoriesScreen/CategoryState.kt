package com.zseni.librebook.presentation.screen.categoriesScreen

import com.zseni.librebook.domain.model.Results

data class CategoryState(
    val isLoading:Boolean = false,
    val popularBooks:List<Results> = emptyList(),
    val artBooks:List<Results> = emptyList(),
    val englishBooks:List<Results> = emptyList(),
    val frenchorFinish:List<Results> = emptyList(),
    val spanishBook:List<Results> = emptyList(),
    val historyBooks:List<Results> = emptyList(),
    val warBooks: List<Results> = emptyList(),
    val childrenBooks:List<Results> = emptyList(),
    val scienceBooks: List<Results> = emptyList(),
    val biographyBooks:List<Results> = emptyList(),
    val lawBooks:List<Results> = emptyList(),
    val mysteryBooks: List<Results> = emptyList(),
    val cookingBooks:List<Results> = emptyList(),
    val geologyBooks: List<Results> = emptyList(),
    val error:String =  ""


)
