package com.zseni.librebook.data.remoteModel

import retrofit2.http.GET
import retrofit2.http.Query
/**
Api service is used in the Repository Implementation
 Check usecases for further info
 */
interface BookService {

    @GET("/books?ids=1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,39,31,32")
    suspend fun getPopularBooks():BooksDto

    @GET("/books?languages=en")
    suspend fun getEnglishBooks():BooksDto

    @GET("/books?languages=fr,fi")
    suspend fun getFrenchorFinishBooks():BooksDto

    @GET("/books?languages=es")
    suspend fun getSpanishBooks():BooksDto

    @GET("/books?topic=history")
    suspend fun getHistoryBooks():BooksDto

    @GET("/books?topic=war")
    suspend fun getWarBooks():BooksDto

    @GET("/books?topic=children")
    suspend fun getChildrenBooks():BooksDto

    @GET("/books?topic=science")
    suspend fun getScienceBooks():BooksDto

    @GET("/books?topic=biography")
    suspend fun getBiographyBooks():BooksDto

    @GET("/books?topic=law")
    suspend fun getLawBooks():BooksDto

    @GET("/books?topic=mystery")
    suspend fun getMysteryBooks():BooksDto

    @GET("/books?topic=cooking")
    suspend fun getCookingBooks():BooksDto

    @GET("/books?topic=art")
    suspend fun getArtBooks():BooksDto

    @GET("/books?topic=geology")
    suspend fun getGeologyBooks():BooksDto

    @GET("books")
    suspend fun getBooksDetail(@Query ("ids") id:String ):BooksDto

    @GET("books")
    suspend fun getSearchBooks(@Query("search") authororBookName:String):BooksDto


}