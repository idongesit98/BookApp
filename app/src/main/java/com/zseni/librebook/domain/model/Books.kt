package com.zseni.librebook.domain.model


data class Books(
    val count: Int?,
    val next: String?,
    val previous: Any?,
    val results: List<Results>?
)
