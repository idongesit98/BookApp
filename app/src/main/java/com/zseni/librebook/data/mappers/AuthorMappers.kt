package com.zseni.librebook.data.mappers

import com.zseni.librebook.data.local.AuthorEntity
import com.zseni.librebook.data.remoteModel.AuthorDto
import com.zseni.librebook.domain.model.Author

fun AuthorDto.toAuthorEntity():AuthorEntity{
    return AuthorEntity(
        name = name,
        birthYear = birthYear,
        deathYear = deathYear
    )
}

fun AuthorEntity.toAuthors():Author{
    return Author(
        name = name,
        birthYear = birthYear,
        deathYear = deathYear
    )
}