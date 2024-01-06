package com.zseni.librebook.presentation.screen.detailScreen

import com.zseni.librebook.data.room.assetModel.BooksItem

sealed class DetailViewState{
    object Empty: DetailViewState()
    object Loading: DetailViewState()
    data class Success(val data: BooksItem): DetailViewState()
    data class Error(val exception:Throwable): DetailViewState()
}
