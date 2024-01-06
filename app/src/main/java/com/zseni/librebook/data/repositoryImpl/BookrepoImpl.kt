package com.zseni.librebook.data.repositoryImpl

import com.zseni.librebook.data.remoteModel.BookService
import com.zseni.librebook.data.remoteModel.BooksDto
import com.zseni.librebook.domain.repositories.BookRepository
import javax.inject.Inject

class BookRepoImpl @Inject constructor(val bookApiService:BookService):BookRepository{
    override suspend fun getPopularBooks(): BooksDto {
        return bookApiService.getPopularBooks()
    }

    override suspend fun getArtBooks(): BooksDto {
        return bookApiService.getArtBooks()
    }

    override suspend fun getEnglishBooks(): BooksDto {
        return bookApiService.getEnglishBooks()
    }

    override suspend fun getFrenchorFinishBooks(): BooksDto {
        return bookApiService.getFrenchorFinishBooks()
    }

    override suspend fun getSpanishBooks(): BooksDto {
        return bookApiService.getSpanishBooks()
    }

    override suspend fun getHistoryBooks(): BooksDto {
        return bookApiService.getHistoryBooks()
    }

    override suspend fun getWarBooks(): BooksDto {
        return bookApiService.getWarBooks()
    }

    override suspend fun getChildrenBooks(): BooksDto {
        return bookApiService.getChildrenBooks()
    }

    override suspend fun getScienceBooks(): BooksDto {
        return bookApiService.getScienceBooks()
    }

    override suspend fun getBiographyBooks(): BooksDto {
        return bookApiService.getBiographyBooks()
    }

    override suspend fun getLawBooks(): BooksDto {
        return bookApiService.getLawBooks()
    }

    override suspend fun getMysteryBooks(): BooksDto {
        return bookApiService.getMysteryBooks()
    }

    override suspend fun getCookingBooks(): BooksDto {
        return bookApiService.getCookingBooks()
    }

    override suspend fun getGeologyBooks(): BooksDto {
        return bookApiService.getGeologyBooks()
    }

    override suspend fun getBookDetails(id: String): BooksDto {
        return bookApiService.getBooksDetail(id)
    }

    override suspend fun getSearchBook(authororBookName: String): BooksDto {
      return bookApiService.getSearchBooks(authororBookName)
    }

}

