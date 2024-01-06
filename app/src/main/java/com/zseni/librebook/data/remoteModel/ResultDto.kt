package com.zseni.librebook.data.remoteModel

import com.google.gson.annotations.SerializedName
import com.zseni.librebook.domain.model.Results

data class ResultDto(
    @SerializedName("authors") val authors: List<AuthorDto>,
    @SerializedName ("bookshelves") val bookshelves: List<String>,
    @SerializedName("copyright") val copyright: Boolean,
    @SerializedName("download_count") val downloadCount: Int,
    @SerializedName("formats") val formats: FormatsDto?,
    @SerializedName("id") val id: Int,
    @SerializedName ("languages") val languages: List<String>,
    @SerializedName ("media_type") val mediaType: String,
    @SerializedName ("subjects") val subjects: List<String>,
    @SerializedName ("title") val title: String,
    @SerializedName ("translators") val translators: List<TranslatorDto>
)

fun ResultDto.toResult(): Results {
    return Results(
        authors = authors.map {
            it.toAuthor()
        },
        bookshelves = bookshelves,
        copyright = copyright,
        formats = formats?.toFormat(),
        id = id,
        languages = languages,
        download_count = downloadCount,
        subjects = subjects,
        title = title,
        media_type = mediaType
    )
}