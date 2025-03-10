package com.example.teamscheduleapp.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.teamscheduleapp.presentation.view.homescreen.ScheduleScreen

/**
 * This file defines the main navigation structure for the NFL Schedule app using Jetpack Compose Navigation.
 * - `NFLApp()`: Manages navigation across different screens.
 * - Uses `NavHost` with `NavController` to control screen transitions.
 * - Starts with the `ScheduleScreen`.
 */
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NFLApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "schedule") {
        composable("schedule") { ScheduleScreen() }
    }
}


