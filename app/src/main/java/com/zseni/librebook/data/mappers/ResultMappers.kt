package com.zseni.librebook.data.mappers

import com.zseni.librebook.data.local.ResultEntity
import com.zseni.librebook.data.remoteModel.ResultDto
import com.zseni.librebook.domain.model.Results

fun ResultDto.toResultsEntity():ResultEntity{
    return ResultEntity(
        id = id,
        title = title,
        authors = authors.map {
            it.toAuthorEntity()
        },
        subjects = subjects,
        bookshelves = bookshelves,
        languages = languages,
        mediaType = mediaType,
        formats = formats?.toFormatEntity(),
        downloadCount = downloadCount,
        copyright = copyright
    )
}

fun ResultEntity.toResults():Results{
    return Results(
        id = id,
        title = title,
        authors = authors.map {
            it.toAuthors()
        },
        subjects = subjects,
        bookshelves = bookshelves,
        download_count = downloadCount,
        languages = languages,
        formats = formats?.toFormat(),
        media_type = mediaType,
        copyright = copyright
    )
}