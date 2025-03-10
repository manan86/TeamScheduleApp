package com.example.teamscheduleapp.domain.usecase

import com.example.teamscheduleapp.MainCoroutineRule
import com.example.teamscheduleapp.data.remote.ScheduleResponse
import com.example.teamscheduleapp.domain.repository.IScheduleRepository
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.io.IOException

/**
 * Unit tests for [GetScheduleUseCase].
 *
 * **Purpose:**
 * - Verifies that the `GetScheduleUseCase` correctly interacts with the repository.
 * - Ensures proper handling of successful API responses and failures.
 * - Uses **MockK** for mocking dependencies.
 * - Runs coroutine-based tests using **MainCoroutineRule**.
 *
 * **Test Cases Covered:**
 * 1. **Successful Response** → Should return `Result.success(data)` when API call succeeds.
 * 2. **Failure Scenario** → Should return `Result.failure(exception)` when API call fails.
 */
@ExperimentalCoroutinesApi
class GetScheduleUseCaseTest {

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private val repository = mockk<IScheduleRepository>()
    private lateinit var useCase: GetScheduleUseCase

    @Before
    fun setUp() {
        useCase = GetScheduleUseCase(repository)
    }

    @Test
    fun `GIVEN successful repository response WHEN execute is called THEN return success`() = runTest {
        val mockResponse = mockk<ScheduleResponse>()
        coEvery { repository.getSchedule() } returns mockResponse

        val result = useCase.execute()

        assertTrue(result.isSuccess)
        assertEquals(mockResponse, result.getOrNull())
        coVerify { repository.getSchedule() }
    }

    @Test
    fun `GIVEN repository throws exception WHEN execute is called THEN return failure`() = runTest {
        val exception = IOException("Network error")
        coEvery { repository.getSchedule() } throws exception

        val result = useCase.execute()

        assertTrue(result.isFailure)
        assertEquals(exception, result.exceptionOrNull())
    }
}
