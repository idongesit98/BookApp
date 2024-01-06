package com.zseni.librebook.di

import com.zseni.librebook.data.remoteModel.BookService
import com.zseni.librebook.data.repositoryImpl.BookRepoImpl
import com.zseni.librebook.domain.repositories.BookRepository
import com.zseni.librebook.presentation.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService():BookService{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BookService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(apiService:BookService):BookRepository{
        return BookRepoImpl(apiService)
    }

}