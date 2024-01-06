package com.zseni.librebook.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zseni.librebook.data.room.assetModel.BooksItem
import com.zseni.librebook.presentation.screen.detailScreen.DetailViewState
import com.zseni.librebook.presentation.screen.homeScreen.ViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json


class MainViewModel:ViewModel() {
    private val _uiState = MutableStateFlow<ViewState>(ViewState.Loading)
    val uiState = _uiState.asStateFlow()
    private val _uiDetailState = MutableStateFlow<DetailViewState>(DetailViewState.Loading)
    val uiDetailState = _uiDetailState.asStateFlow()

// Helps format the json
private val format = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
        isLenient = true
    }

    fun getAllBooks(context: Context) = viewModelScope.launch{
        try {
            // read the json file
            val myJson = context.assets.open("books.json").bufferedReader().use {
                it.readText()
            }
            // format the json
            val bookLists = format.decodeFromString<List<BooksItem>>(myJson)
            _uiState.value = ViewState.Success(bookLists)
        }
        catch (e:Exception){
            _uiState.value = ViewState.Error(e)
        }
    }

    fun getBooksById(context: Context, isbnNo:String) = viewModelScope.launch {
        try {
            // read the json file
            val myJson = context.assets.open("books.json").bufferedReader().use {
                it.readText()
            }
            // format the json
            val bookLists = format.decodeFromString<List<BooksItem>>(myJson)
                .filter { it.isbn.contentEquals(isbnNo) }.first()
            _uiDetailState.value = DetailViewState.Success(bookLists)
        }
        catch (e:Exception){
            _uiDetailState.value = DetailViewState.Error(e)

        }

    }
}