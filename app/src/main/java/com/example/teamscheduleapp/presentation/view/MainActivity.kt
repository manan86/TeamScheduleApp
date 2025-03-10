package com.example.teamscheduleapp.presentation.view

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import com.example.teamscheduleapp.presentation.navigation.NFLApp
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main entry point of the app, sets up Compose UI and enables edge-to-edge display.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NFLApp()
        }
    }
}


