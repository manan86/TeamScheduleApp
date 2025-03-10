package com.example.teamscheduleapp.data.remote

import com.example.teamscheduleapp.utils.Constants.ENDPOINT_SCHEDULE
import retrofit2.Response
import retrofit2.http.GET

/**
 * Retrofit API interface for fetching the team schedule data.
 * Defines a single endpoint to retrieve schedule details from the server.
 */
interface ScheduleApi {
    @GET(ENDPOINT_SCHEDULE)
    suspend fun getSchedule(): Response<ScheduleResponse>
}

