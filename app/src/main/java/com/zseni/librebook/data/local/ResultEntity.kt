package com.zseni.librebook.data.local

import androidx.room.PrimaryKey
import com.zseni.librebook.data.remoteModel.FormatsDto

data class ResultEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val authors: List<AuthorEntity>,
    val subjects: List<String>,
    val bookshelves: List<String>,
    val languages: List<String>,
    val copyright:Boolean,
    val mediaType: String,
    val formats: FormatEntity?,
    val downloadCount: Int,
)