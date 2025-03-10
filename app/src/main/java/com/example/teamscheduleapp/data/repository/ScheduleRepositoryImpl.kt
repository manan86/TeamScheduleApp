package com.example.teamscheduleapp.data.repository

import com.example.teamscheduleapp.data.remote.ScheduleApi
import com.example.teamscheduleapp.data.remote.ScheduleResponse
import com.example.teamscheduleapp.domain.repository.IScheduleRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * Repository implementation for fetching the schedule from the API.
 * Handles API responses, error handling, and ensures data integrity.
 */
class ScheduleRepositoryImpl @Inject constructor(
    private val api: ScheduleApi
) : IScheduleRepository {
    override suspend fun getSchedule(): ScheduleResponse {
        return try {
            val response = api.getSchedule()
            if (response.isSuccessful) {
                response.body() ?: throw IOException("Empty response from server")
            } else {
                throw HttpException(response)
            }
        } catch (e: IOException) {
            throw Exception("Network error: Unable to connect. Check your internet.")
        } catch (e: HttpException) {
            throw Exception("Server error: ${e.message()}")
        } catch (e: Exception) {
            throw Exception("Unexpected error: ${e.localizedMessage}")
        }
    }
}
