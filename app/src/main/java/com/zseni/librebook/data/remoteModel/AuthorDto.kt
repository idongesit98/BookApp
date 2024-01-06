package com.zseni.librebook.data.remoteModel

import com.google.gson.annotations.SerializedName
import com.zseni.librebook.domain.model.Author

data class AuthorDto(
    @SerializedName("name") val name: String,
    @SerializedName("birth_year") val birthYear : Int,
    @SerializedName("death_year") val deathYear : Int,
)

fun AuthorDto.toAuthor(): Author {
    return Author(
        name = name,
        birthYear = birthYear,
        deathYear = deathYear
    )
}