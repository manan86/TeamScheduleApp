package com.example.teamscheduleapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Application class for the Team Schedule App.
 * This class is annotated with @HiltAndroidApp to initialize Dagger Hilt for dependency injection.
 */
@HiltAndroidApp
class TeamScheduleApp : Application()


