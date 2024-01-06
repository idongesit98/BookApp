package com.zseni.librebook.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zseni.librebook.domain.usecases.getBook_Case.SearchBooksUseCase
import com.zseni.librebook.presentation.screen.search.SearchState
import com.zseni.librebook.presentation.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchCase: SearchBooksUseCase
):ViewModel(){

    private val _searchState = MutableStateFlow(SearchState())
    val searchState = _searchState.asStateFlow()

    fun search(authorOrBook:String){
        searchCase(authorOrBook).onEach { result ->
            when (result){
                is Resource.Success ->{
                    _searchState.update {
                        it.copy(
                            isLoading = false,
                            books = result.data?.results?: emptyList()
                        )
                    }
                }

                is Resource.Error -> {
                    _searchState.update {
                        it.copy(
                            isLoading = false,
                            books = result.data?.results?: emptyList()
                        )
                    }
                }

                is Resource.Loading ->{
                    _searchState.update {
                        it.copy(
                            isLoading = true,
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}