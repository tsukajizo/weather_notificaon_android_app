package com.tsukajizo.weathers.ui.home

import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable

/**
 * com.tsukajizo.weathers.ui.home
 */
@Composable
fun HomeView(onNavToSettings: () -> Unit) {
    Surface {
        Button(onClick = onNavToSettings){
            "settings"
        }
    }
}