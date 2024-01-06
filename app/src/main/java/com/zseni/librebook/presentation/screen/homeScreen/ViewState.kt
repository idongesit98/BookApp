package com.zseni.librebook.presentation.screen.homeScreen

import com.zseni.librebook.data.room.assetModel.BooksItem

sealed class ViewState{
    object Empty: ViewState()
    object Loading: ViewState()
    data class Success(val data:List<BooksItem>): ViewState()
    data class Error(val exception:Throwable): ViewState()
}
