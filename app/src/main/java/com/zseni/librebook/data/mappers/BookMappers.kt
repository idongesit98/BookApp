package com.zseni.librebook.data.mappers

import com.zseni.librebook.data.local.BookEntity
import com.zseni.librebook.data.remoteModel.BooksDto
import com.zseni.librebook.data.remoteModel.toResult
import com.zseni.librebook.domain.model.Books

fun BooksDto.toBookEntity():BookEntity{
    return BookEntity(
        count, next, previous,
        results = results?.map {
            it.toResultsEntity()
        }
    )
}

fun BookEntity.toBooks():Books{
    return Books(
        count, next, previous,
        results = results?.map {
            it.toResults()
        }
    )
}