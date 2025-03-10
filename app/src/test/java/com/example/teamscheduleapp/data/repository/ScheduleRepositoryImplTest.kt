package com.example.teamscheduleapp.data.repository

import com.example.teamscheduleapp.MainCoroutineRule
import com.example.teamscheduleapp.data.remote.ScheduleApi
import com.example.teamscheduleapp.data.remote.ScheduleResponse
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

/**
 * Unit tests for [ScheduleRepositoryImpl].
 *
 * **Purpose:**
 * - Ensures that `ScheduleRepositoryImpl` correctly fetches schedule data from `ScheduleApi`.
 * - Verifies successful API responses and proper exception handling.
 * - Uses **MockK** for dependency mocking.
 * - Uses **MainCoroutineRule** to support coroutine-based testing.
 *
 * **Test Cases Covered:**
 * 1. **Successful Response** → `getSchedule()` should return the correct schedule data.
 * 2. **Exception Handling** → `getSchedule()` should properly throw an exception when API call fails.
 */
@ExperimentalCoroutinesApi
class ScheduleRepositoryImplTest {

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private val api = mockk<ScheduleApi>()
    private lateinit var repository: ScheduleRepositoryImpl


    @Before
    fun setUp() {
        repository = ScheduleRepositoryImpl(api)
    }

    @Test
    fun `GIVEN successful response WHEN getSchedule is called THEN return schedule response`() = runTest {
        val mockResponse = mockk<ScheduleResponse>()
        coEvery { api.getSchedule() } returns Response.success(mockResponse)

        val result = repository.getSchedule()

        assertEquals(mockResponse, result)
        coVerify { api.getSchedule() }
    }

    @Test
    fun `GIVEN unexpected exception WHEN getSchedule is called THEN throw generic Exception`() = runTest {
        coEvery { api.getSchedule() } throws RuntimeException("Something went wrong")

        val exception = runCatching {
            repository.getSchedule()
        }.exceptionOrNull()

        assertNotNull(exception)
        assertTrue(exception is Exception)
        assertTrue(exception?.message!!.contains("Something went wrong"))
    }
}

