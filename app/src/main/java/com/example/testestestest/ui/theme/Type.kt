package com.example.testestestest.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.testestestest.enums.Themes
import com.example.testestestest.ui.theme.themes.original.darkSecondaryScheme
import com.example.testestestest.ui.theme.themes.original.lightSecondaryScheme
import com.example.testestestest.ui.theme.themes.original.original.darkOriginalScheme
import com.example.testestestest.ui.theme.themes.original.original.lightOriginalScheme

@Composable
fun TestTheme(
    themes: Themes,
    darkMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    var colorScheme = when(themes){
        Themes.ORIGINAL -> if (darkMode) darkOriginalScheme else lightOriginalScheme
        Themes.SECONDARY -> if (darkMode) darkSecondaryScheme else lightSecondaryScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}