package com.zseni.librebook.data.remoteModel

import com.google.gson.annotations.SerializedName
import com.zseni.librebook.domain.model.Translator

data class TranslatorDto(
    @SerializedName("birth_year") val birthYear: Any,
    @SerializedName("death_year")val deathYear: Any,
    @SerializedName("name") val name: String
)

fun TranslatorDto.toTranslator(): Translator {
    return Translator(
        name = name
    )
}