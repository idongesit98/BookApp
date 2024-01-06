package com.zseni.librebook.domain.model

import com.zseni.librebook.data.remoteModel.FormatsDto
import com.zseni.librebook.data.remoteModel.TranslatorDto

data class Results(
    val authors: List<Author>,
    val bookshelves: List<String>,
    val copyright: Boolean,
    val download_count: Int,
    val formats: Format?,
    val id: Int,
    val languages: List<String>,
    val media_type: String,
    val subjects: List<String>,
    val title: String,
    //val translators: List<TranslatorDto>
)
