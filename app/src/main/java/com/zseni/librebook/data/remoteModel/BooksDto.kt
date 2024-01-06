package com.zseni.librebook.data.remoteModel

import com.zseni.librebook.domain.model.Books

data class BooksDto(
    val count: Int?,
    val next: String?,
    val previous: Any?,
    val results: List<ResultDto>?
)

fun BooksDto.toBookDto(): Books {
    return Books(
        count = count,
        next = next,
        previous = previous,
        results = results?.map {
            it.toResult()
        }
    )
}