package com.example.teamscheduleapp.domain.usecase

import com.example.teamscheduleapp.data.remote.ScheduleResponse
import com.example.teamscheduleapp.domain.repository.IScheduleRepository
import javax.inject.Inject

/**
 * Use case for fetching the team schedule.
 * It abstracts the data retrieval logic and handles potential exceptions.
 */
class GetScheduleUseCase @Inject constructor(
    private val repository: IScheduleRepository
) {
    suspend fun execute(): Result<ScheduleResponse> {
        return try {
            val response = repository.getSchedule()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
