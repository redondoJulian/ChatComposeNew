package com.example.testestestest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.testestestest.enums.Themes
import com.example.testestestest.ui.theme.TestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var selectTheme by remember { mutableStateOf<Themes>(Themes.ORIGINAL ) }
            TestTheme(themes = selectTheme) {
                ChatScreen(onChangeTheme = {
                    DALE ->
                    selectTheme = DALE
                    Log.d("SCHEME", DALE.toString())
                })
            }
        }
    }
}