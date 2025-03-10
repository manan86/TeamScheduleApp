package com.example.teamscheduleapp.domain.repository

import com.example.teamscheduleapp.data.remote.ScheduleResponse

/**
 * Repository interface for fetching the schedule data.
 * Defines the contract for data retrieval from a remote source.
 */
interface IScheduleRepository {
     suspend fun getSchedule(): ScheduleResponse
}

