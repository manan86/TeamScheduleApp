package com.example.teamscheduleapp.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teamscheduleapp.data.remote.GameSection
import com.example.teamscheduleapp.domain.usecase.GetScheduleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel responsible for managing and exposing the schedule data to the UI layer.
 * - Uses Hilt for dependency injection.
 * - Fetches data using `GetScheduleUseCase` and updates state.
 * - Handles errors and exposes an error state for UI handling.
 * - Uses `viewModelScope` to manage coroutine lifecycle.
 */
@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val getScheduleUseCase: GetScheduleUseCase
) : ViewModel() {

    private val _scheduleState = mutableStateOf<List<GameSection>>(emptyList())
    val scheduleState: State<List<GameSection>> = _scheduleState

    private val _errorState = mutableStateOf<String?>(null)
    val errorState: State<String?> = _errorState

    init {
        fetchSchedule()
    }

    fun fetchSchedule() {
        viewModelScope.launch {
            try {
                val result = getScheduleUseCase.execute()
                result.onSuccess { response ->
                    _scheduleState.value = response.gameSections
                }.onFailure { exception ->
                    _errorState.value = exception.localizedMessage
                    Log.e("ScheduleViewModel", "Error: ${exception.localizedMessage}")
                }
            } catch (e: Exception) {
                _errorState.value = "Unexpected error occurred"
                Log.e("ScheduleViewModel", "Unhandled error", e)
            }
        }
    }
}