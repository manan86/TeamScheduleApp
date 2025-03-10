package com.example.teamscheduleapp.utils

import java.text.SimpleDateFormat
import java.util.*

/**
* Utility functions for formatting ISO date and time strings into human-readable formats.
*/

/**
 * Converts an ISO 8601 date string into a formatted date (e.g., "Fri, Mar 8").
 * Returns "Unknown Date" if parsing fails.
 */
fun formatISODate(isoDate: String?): String {
    return try {
        if (isoDate.isNullOrBlank()) return "Unknown Date"

        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val outputFormat = SimpleDateFormat("EEE, MMM d", Locale.getDefault())

        val date = inputFormat.parse(isoDate)
        date?.let { outputFormat.format(it) } ?: "Unknown Date"
    } catch (e: Exception) {
        "Invalid Date"
    }
}

/**
 * Converts an ISO 8601 date string into a formatted time (e.g., "3:30 PM").
 * Returns "TBD" if parsing fails.
 */
fun formatTime(isoDate: String?): String {
    return try {
        if (isoDate.isNullOrBlank()) return "TBD"

        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val outputFormat = SimpleDateFormat("h:mm a", Locale.getDefault())

        val date = inputFormat.parse(isoDate)
        date?.let { outputFormat.format(it) } ?: "TBD"
    } catch (e: Exception) {
        "Invalid Time"
    }
}
