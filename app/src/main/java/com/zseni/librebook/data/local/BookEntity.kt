package com.zseni.librebook.data.local

import androidx.room.Entity
import com.zseni.librebook.data.remoteModel.ResultDto

@Entity
data class BookEntity(
    val count: Int?,
    val next: String?,
    val previous: Any?,
    val results: List<ResultEntity>?
)
