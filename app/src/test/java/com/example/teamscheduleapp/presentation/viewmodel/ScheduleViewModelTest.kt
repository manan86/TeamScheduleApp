package com.example.teamscheduleapp.presentation.viewmodel

import android.util.Log
import com.example.teamscheduleapp.MainCoroutineRule
import com.example.teamscheduleapp.data.remote.GameSection
import com.example.teamscheduleapp.data.remote.ScheduleResponse
import com.example.teamscheduleapp.domain.usecase.GetScheduleUseCase
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Unit tests for [ScheduleViewModel].
 *
 * **Purpose:**
 * - Validates that `ScheduleViewModel` correctly interacts with `GetScheduleUseCase`.
 * - Ensures that the **schedule state** updates correctly when API responses are received.
 * - Tests error handling scenarios to confirm that errors are logged and surfaced properly.
 * - Uses **MockK** for dependency mocking and **MainCoroutineRule** for coroutine-based testing.
 *
 * **Test Cases Covered:**
 * 1. **Successful Response** → The schedule state should be updated correctly.
 * 2. **API Error Handling** → Errors should be captured and reflected in the error state.
 */
@ExperimentalCoroutinesApi
class ScheduleViewModelTest {

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private val useCase = mockk<GetScheduleUseCase>()
    private lateinit var viewModel: ScheduleViewModel

    @Before
    fun setUp() {
        mockkStatic(Log::class)
        every { Log.e(any(), any()) } returns 0

        coEvery { useCase.execute() } returns Result.success(ScheduleResponse(mockk(), emptyList()))

        viewModel = ScheduleViewModel(useCase)
    }

    @Test
    fun `GIVEN successful response WHEN fetchSchedule is called THEN update scheduleState`() = runTest {
        val mockGameSections = listOf(mockk<GameSection>())
        val mockResponse = ScheduleResponse(mockk(), mockGameSections)
        coEvery { useCase.execute() } returns Result.success(mockResponse)

        viewModel.fetchSchedule()

        assertEquals(mockGameSections, viewModel.scheduleState.value)
        assertNull(viewModel.errorState.value)
        coVerify { useCase.execute() }
    }

    @Test
    fun `GIVEN API error WHEN fetchSchedule is called THEN update errorState`() = runTest {
        val exception = Exception("API Error")
        coEvery { useCase.execute() } returns Result.failure(exception)

        viewModel.fetchSchedule()

        assertNotNull(viewModel.errorState.value)
        assertTrue(viewModel.errorState.value!!.contains("API Error"))
        assertTrue(viewModel.scheduleState.value.isEmpty())
    }
}
