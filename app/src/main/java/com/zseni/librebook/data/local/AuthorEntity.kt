package com.zseni.librebook.data.local

import androidx.room.Entity
import com.zseni.librebook.data.remoteModel.AuthorDto

@Entity
data class AuthorEntity(
    val name: String,
    val birthYear : Int,
    val deathYear : Int,
)
