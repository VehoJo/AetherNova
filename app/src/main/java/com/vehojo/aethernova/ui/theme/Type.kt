package com.vehojo.aethernova.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.vehojo.aethernova.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
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

val PlusJakartaSans_SemiBold = FontFamily(
    Font(
        resId = R.font.pjssemibold
    )
)
val PlusJakartaSans_Medium = FontFamily(
    Font(
        resId = R.font.pjsmedium
    )
)
val PlusJakartaSans_Bold = FontFamily(
    Font(
        resId = R.font.pjsbold
    )
)
val PlusJakartaSans_Regular = FontFamily(
    Font(
        resId = R.font.pjsregular
    )
)
val Orbitron_Black = FontFamily(
    Font(
        resId = R.font.orbitronblack
    )
)
val Orbitron_Bold = FontFamily(
    Font(
        resId = R.font.orbitronbold
    )
)
