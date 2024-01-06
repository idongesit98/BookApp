package com.zseni.librebook.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zseni.librebook.domain.usecases.getBook_Case.ArtUseCase
import com.zseni.librebook.domain.usecases.getBook_Case.BiographyUseCase
import com.zseni.librebook.domain.usecases.getBook_Case.ChildrenBookUseCase
import com.zseni.librebook.domain.usecases.getBook_Case.CookingBookUseCase
import com.zseni.librebook.domain.usecases.getBook_Case.EnglishUseCase
import com.zseni.librebook.domain.usecases.getBook_Case.FrenchFinnishUseCase
import com.zseni.librebook.domain.usecases.getBook_Case.GeologyUseCase
import com.zseni.librebook.domain.usecases.getBook_Case.HistoryBookUseCase
import com.zseni.librebook.domain.usecases.getBook_Case.LawBookUseCase
import com.zseni.librebook.domain.usecases.getBook_Case.MysteryBookUse
import com.zseni.librebook.domain.usecases.getBook_Case.PopularBookUseCase
import com.zseni.librebook.domain.usecases.getBook_Case.ScienceBookUseCase
import com.zseni.librebook.domain.usecases.getBook_Case.SpanishBookUseCase
import com.zseni.librebook.domain.usecases.getBook_Case.WarBookUseCase
import com.zseni.librebook.presentation.screen.categoriesScreen.CategoryState
import com.zseni.librebook.presentation.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val popularBookUseCase: PopularBookUseCase,
    private val biographyUseCase: BiographyUseCase,
    private val childrenBookUseCase: ChildrenBookUseCase,
    private val cookingBookUseCase: CookingBookUseCase,
    private val englishUseCase: EnglishUseCase,
    private val frenchFinnishUseCase: FrenchFinnishUseCase,
    private val geologyUseCase: GeologyUseCase,
    private val historyBookUseCase: HistoryBookUseCase,
    private val lawBookUseCase: LawBookUseCase,
    private val mysteryBookUse: MysteryBookUse,
    private val scienceBookUseCase: ScienceBookUseCase,
    private val spanishBookUseCase: SpanishBookUseCase,
    private val warBooksUseCase: WarBookUseCase,
    private val artUseCase:ArtUseCase
):ViewModel() {
    private val _uiState =  MutableStateFlow(CategoryState())
    val uiState = _uiState.asStateFlow()

    init {
        getPopularBooks()
        getBiographyBooks()
        getEnglishBooks()
        getfrenchorFinishBooks()
        getSpanishBooks()
        getScienceBooks()
        getHistoryBooks()
        getWarBooks()
        getChildrenBooks()
        getLawBooks()
        getMysteryBooks()
        getCookingBooks()
        getGeologyBooks()
        getArtBooks()
    }

    private fun getPopularBooks(){
        popularBookUseCase().onEach { result ->
            when (result){
                is Resource.Success ->{
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            popularBooks = result.data?.results?: emptyList()
                        )
                    }
                    Log.d("BOOK_LIST", "Success:${result.data?.results}")
                }

                is Resource.Error -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = result.message?: "Unexpected error occurred"
                        )
                    }
                    Log.d("BOOK_LIST", "error")
                }

                is Resource.Loading ->{
                    _uiState.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                    Log.d("BOOK_LIST", "Loading")
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getBiographyBooks(){
        biographyUseCase().onEach { result ->
            when (result){
                is Resource.Success ->{
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            biographyBooks = result.data?.results?: emptyList()
                        )
                    }
                    Log.d("BOOK_LIST", "Success:${result.data?.results}")
                }

                is Resource.Error -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = result.message?: "Unexpected error occurred"
                        )
                    }
                    Log.d("BOOK_LIST", "error")
                }

                is Resource.Loading ->{
                    _uiState.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                    Log.d("BOOK_LIST", "Loading")
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getEnglishBooks(){
        englishUseCase().onEach { result ->
            when (result){
                is Resource.Success ->{
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            englishBooks = result.data?.results?: emptyList()
                        )
                    }
                    Log.d("BOOK_LIST", "Success:${result.data?.results}")
                }

                is Resource.Error -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = result.message?: "Unexpected error occurred"
                        )
                    }
                    Log.d("BOOK_LIST", "error")
                }

                is Resource.Loading ->{
                    _uiState.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                    Log.d("BOOK_LIST", "Loading")
                }
            }
        }.launchIn(viewModelScope)
    }
    private fun getArtBooks(){
        artUseCase().onEach { result ->
            when (result){
                is Resource.Success ->{
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            artBooks = result.data?.results?: emptyList()
                        )
                    }
                    Log.d("BOOK_LIST", "Success:${result.data?.results}")
                }

                is Resource.Error -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = result.message?: "Unexpected error occurred"
                        )
                    }
                    Log.d("BOOK_LIST", "error")
                }

                is Resource.Loading ->{
                    _uiState.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                    Log.d("BOOK_LIST", "Loading")
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getfrenchorFinishBooks(){
        frenchFinnishUseCase().onEach { result ->
            when (result){
                is Resource.Success ->{
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            frenchorFinish = result.data?.results?: emptyList()
                        )
                    }
                    Log.d("BOOK_LIST", "Success:${result.data?.results}")
                }

                is Resource.Error -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = result.message?: "Unexpected error occurred"
                        )
                    }
                    Log.d("BOOK_LIST", "error")
                }

                is Resource.Loading ->{
                    _uiState.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                    Log.d("BOOK_LIST", "Loading")
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getSpanishBooks(){
        spanishBookUseCase().onEach { result ->
            when (result){
                is Resource.Success ->{
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            spanishBook = result.data?.results?: emptyList()
                        )
                    }
                    Log.d("BOOK_LIST", "Success:${result.data?.results}")
                }

                is Resource.Error -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = result.message?: "Unexpected error occurred"
                        )
                    }
                    Log.d("BOOK_LIST", "error")
                }

                is Resource.Loading ->{
                    _uiState.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                    Log.d("BOOK_LIST", "Loading")
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getHistoryBooks(){
        historyBookUseCase().onEach { result ->
            when (result){
                is Resource.Success ->{
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            historyBooks = result.data?.results?: emptyList()
                        )
                    }
                    Log.d("BOOK_LIST", "Success:${result.data?.results}")
                }

                is Resource.Error -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = result.message?: "Unexpected error occurred"
                        )
                    }
                    Log.d("BOOK_LIST", "error")
                }

                is Resource.Loading ->{
                    _uiState.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                    Log.d("BOOK_LIST", "Loading")
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getWarBooks(){
        warBooksUseCase().onEach { result ->
            when (result){
                is Resource.Success ->{
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            warBooks = result.data?.results?: emptyList()
                        )
                    }
                    Log.d("WAR_LIST", "Success:${result.data?.results}")
                }

                is Resource.Error -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = result.message?: "Unexpected error occurred"
                        )
                    }
                    Log.d("BOOK_LIST", "error")
                }

                is Resource.Loading ->{
                    _uiState.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                    Log.d("BOOK_LIST", "Loading")
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getChildrenBooks(){
        childrenBookUseCase().onEach { result ->
            when (result){
                is Resource.Success ->{
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            childrenBooks = result.data?.results?: emptyList()
                        )
                    }
                    Log.d("BOOK_LIST", "Success:${result.data?.results}")
                }

                is Resource.Error -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = result.message?: "Unexpected error occurred"
                        )
                    }
                    Log.d("BOOK_LIST", "error")
                }

                is Resource.Loading ->{
                    _uiState.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                    Log.d("BOOK_LIST", "Loading")
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getScienceBooks() {
        scienceBookUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            scienceBooks = result.data?.results ?: emptyList()
                        )
                    }
                    Log.d("BOOK_LIST", "Success:${result.data?.results}")
                }

                is Resource.Error -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = result.message ?: "Unexpected error occurred"
                        )
                    }
                    Log.d("BOOK_LIST", "error")
                }

                is Resource.Loading -> {
                    _uiState.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                    Log.d("BOOK_LIST", "Loading")
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getLawBooks(){
        lawBookUseCase().onEach { result ->
            when (result){
                is Resource.Success ->{
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            lawBooks = result.data?.results?: emptyList()
                        )
                    }
                    Log.d("BOOK_LIST", "Success:${result.data?.results}")
                }

                is Resource.Error -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = result.message?: "Unexpected error occurred"
                        )
                    }
                    Log.d("BOOK_LIST", "error")
                }

                is Resource.Loading ->{
                    _uiState.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                    Log.d("BOOK_LIST", "Loading")
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getMysteryBooks(){
        mysteryBookUse().onEach { result ->
            when (result){
                is Resource.Success ->{
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            mysteryBooks = result.data?.results?: emptyList()
                        )
                    }
                    Log.d("BOOK_LIST", "Success:${result.data?.results}")
                }

                is Resource.Error -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = result.message?: "Unexpected error occurred"
                        )
                    }
                    Log.d("BOOK_LIST", "error")
                }

                is Resource.Loading ->{
                    _uiState.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                    Log.d("BOOK_LIST", "Loading")
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getCookingBooks(){
        cookingBookUseCase().onEach { result ->
            when (result){
                is Resource.Success ->{
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            cookingBooks = result.data?.results?: emptyList()
                        )
                    }
                    Log.d("BOOK_LIST", "Success:${result.data?.results}")
                }

                is Resource.Error -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = result.message?: "Unexpected error occurred"
                        )
                    }
                    Log.d("BOOK_LIST", "error")
                }

                is Resource.Loading ->{
                    _uiState.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                    Log.d("BOOK_LIST", "Loading")
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getGeologyBooks(){
        geologyUseCase().onEach { result ->
            when (result){
                is Resource.Success ->{
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            geologyBooks = result.data?.results?: emptyList()
                        )
                    }
                    Log.d("BOOK_LIST", "Success:${result.data?.results}")
                }

                is Resource.Error -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = result.message?: "Unexpected error occurred"
                        )
                    }
                    Log.d("BOOK_LIST", "error")
                }

                is Resource.Loading ->{
                    _uiState.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                    Log.d("BOOK_LIST", "Loading")
                }
            }
        }.launchIn(viewModelScope)
    }
}