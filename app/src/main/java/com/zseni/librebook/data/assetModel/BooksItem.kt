package com.zseni.librebook.data.room.assetModel

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient


//TODO: Add Serializable plugin in the next gradle build in build.gradle.kts(app) to enable the project work
/**
 * @Transient annotation means you don't need that data from the API
 */
@Serializable
data class BooksItem(
    val authors: List<String> = emptyList(),
    val categories: List<String> = emptyList(),
    val isbn: String = "",
    val longDescription: String = "",
    @Transient val pageCount: Int = 0,
    @Transient val publishedDate:String = "",
    val shortDescription: String = "",
    val status: String = "",
    val thumbnailUrl: String = "",
    val title: String = ""
)