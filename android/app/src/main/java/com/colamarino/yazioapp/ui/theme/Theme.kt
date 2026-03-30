
package com.colamarino.yazioapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val ColorPrimary = Color(0xFF4A90E2)
private val ColorAccent = Color(0xFF7ED321)
private val DarkBg = Color(0xFF111114)

private val colorScheme = darkColorScheme(
    primary = ColorPrimary,
    secondary = ColorAccent,
    background = DarkBg
)

@Composable
fun YazioTheme(content: @Composable () -> Unit){
    MaterialTheme(
        colorScheme = colorScheme,
        typography = androidx.compose.material3.Typography(),
        content = content
    )
}
