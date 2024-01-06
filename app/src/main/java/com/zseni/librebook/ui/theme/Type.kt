package com.zseni.librebook.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.zseni.librebook.R

// Set of Material typography styles to start with
 val Gelasio = FontFamily(
    Font(R.font.gelasio),
    Font(R.font.gelasio_medium, FontWeight.W500),
    Font(R.font.gelasio_bold, FontWeight.Bold)
)
val Typography = Typography(
    titleSmall = TextStyle(
        fontFamily = Gelasio,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp
    ),
    displaySmall = TextStyle(
        fontFamily = Gelasio,
        fontWeight = FontWeight.W600,
        fontSize = 10.sp
    ),
    displayMedium = TextStyle(
        fontFamily = Gelasio,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = Gelasio,
        fontWeight = FontWeight.Normal,
        fontSize = 25.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Gelasio,
        fontWeight = FontWeight.Medium,
        fontSize = 11.5.sp,
        lineHeight = 16.sp,
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)