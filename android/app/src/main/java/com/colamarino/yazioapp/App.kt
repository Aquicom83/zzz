
package com.colamarino.yazioapp

import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.colamarino.yazioapp.ui.theme.YazioTheme

@Composable
fun YazioApp(content: @Composable ()->Unit){
    YazioTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            content()
        }
    }
}
