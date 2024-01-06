package com.zseni.librebook.presentation.util

import com.zseni.librebook.R

data class Images(
    val desc:String,
    val imgUri: Int
)

val imgList = listOf(
    Images("first Image",R.drawable.books),
    Images(  "second Image",R.drawable.red_book),
    Images("Third Image",R.drawable.shd_book),
    Images("Fourth Image",R.drawable.student),
    Images("Five Image",R.drawable.studying)
)

