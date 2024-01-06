package com.zseni.librebook.domain.repositories

import com.zseni.librebook.data.remoteModel.BooksDto
import com.zseni.librebook.data.room.assetModel.BooksItem
import retrofit2.http.Query

/**
 * Book repository are used in the Usecases
 */
interface BookRepository {

    suspend fun getPopularBooks():BooksDto
    suspend fun getArtBooks():BooksDto
    suspend fun getEnglishBooks():BooksDto
    suspend fun getFrenchorFinishBooks():BooksDto
    suspend fun getSpanishBooks():BooksDto
    suspend fun getHistoryBooks():BooksDto
    suspend fun getWarBooks():BooksDto
    suspend fun getChildrenBooks():BooksDto
    suspend fun getScienceBooks():BooksDto
    suspend fun getBiographyBooks():BooksDto
    suspend fun getLawBooks():BooksDto
    suspend fun getMysteryBooks():BooksDto
    suspend fun getCookingBooks():BooksDto
    suspend fun getGeologyBooks():BooksDto
    suspend fun getBookDetails(id:String):BooksDto
    suspend fun getSearchBook(@Query("search") authororBookName:String ):BooksDto
}
