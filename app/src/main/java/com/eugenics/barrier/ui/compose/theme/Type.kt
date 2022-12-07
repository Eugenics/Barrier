package com.eugenics.barrier.ui.compose.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.eugenics.barrier.R

val RobotoSerifFamily = FontFamily(
    Font(R.font.robotoserif_regular,FontWeight.Normal),
    Font(R.font.robotoserif_thin,FontWeight.Thin),
    Font(R.font.robotoserif_medium,FontWeight.Medium),
    Font(R.font.robotoserif_light,FontWeight.Light),
    Font(R.font.robotoserif_bold,FontWeight.Bold),
)


val Typography = Typography(
    labelLarge = TextStyle(
        fontFamily = RobotoSerifFamily,
        fontWeight = FontWeight.Medium,
        letterSpacing = 0.1.sp,
        lineHeight = 20.sp,
        fontSize = 14.sp
    ),
    labelMedium = TextStyle(
        fontFamily = RobotoSerifFamily,
        fontWeight = FontWeight.Medium,
        letterSpacing = 0.5.sp,
        lineHeight = 16.sp,
        fontSize = 12.sp
    ),
    labelSmall = TextStyle(
        fontFamily = RobotoSerifFamily,
        fontWeight = FontWeight.Medium,
        letterSpacing = 0.5.sp,
        lineHeight = 16.sp,
        fontSize = 11.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = RobotoSerifFamily,
        fontWeight = FontWeight.W400,
        letterSpacing = 0.5.sp,
        lineHeight = 24.sp,
        fontSize = 16.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = RobotoSerifFamily,
        fontWeight = FontWeight.W400,
        letterSpacing = 0.25.sp,
        lineHeight = 20.sp,
        fontSize = 14.sp
    ),
    bodySmall = TextStyle(
        fontFamily = RobotoSerifFamily,
        fontWeight = FontWeight.W400,
        letterSpacing = 0.4.sp,
        lineHeight = 16.sp,
        fontSize = 12.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = RobotoSerifFamily,
        fontWeight = FontWeight.W400,
        letterSpacing = 0.sp,
        lineHeight = 40.sp,
        fontSize = 32.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = RobotoSerifFamily,
        fontWeight = FontWeight.W400,
        letterSpacing = 0.sp,
        lineHeight = 36.sp,
        fontSize = 28.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = RobotoSerifFamily,
        fontWeight = FontWeight.W400,
        letterSpacing = 0.sp,
        lineHeight = 32.sp,
        fontSize = 24.sp
    ),
    displayLarge = TextStyle(
        fontFamily = RobotoSerifFamily,
        fontWeight = FontWeight.W400,
        letterSpacing = (-0.25).sp,
        lineHeight = 64.sp,
        fontSize = 57.sp
    ),
    displayMedium = TextStyle(
        fontFamily = RobotoSerifFamily,
        fontWeight = FontWeight.W400,
        letterSpacing = 0.sp,
        lineHeight = 52.sp,
        fontSize = 45.sp
    ),
    displaySmall = TextStyle(
        fontFamily = RobotoSerifFamily,
        fontWeight = FontWeight.W400,
        letterSpacing = 0.sp,
        lineHeight = 44.sp,
        fontSize = 36.sp
    ),
    titleLarge = TextStyle(
        fontFamily = RobotoSerifFamily,
        fontWeight = FontWeight.W400,
        letterSpacing = 0.sp,
        lineHeight = 28.sp,
        fontSize = 22.sp
    ),
    titleMedium = TextStyle(
        fontFamily = RobotoSerifFamily,
        fontWeight = FontWeight.Medium,
        letterSpacing = 0.15.sp,
        lineHeight = 24.sp,
        fontSize = 16.sp
    ),
    titleSmall = TextStyle(
        fontFamily = RobotoSerifFamily,
        fontWeight = FontWeight.Medium,
        letterSpacing = 0.1.sp,
        lineHeight = 20.sp,
        fontSize = 14.sp
    ),
)