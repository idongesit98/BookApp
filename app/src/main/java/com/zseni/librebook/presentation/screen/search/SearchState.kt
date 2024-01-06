package com.zseni.librebook.presentation.screen.search

import com.zseni.librebook.domain.model.Results

data class SearchState(
    val isLoading:Boolean = false,
    val books:List<Results> = emptyList(),
    val error:String = ""
)
