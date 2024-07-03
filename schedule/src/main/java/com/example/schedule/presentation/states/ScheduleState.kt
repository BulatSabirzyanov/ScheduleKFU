package com.example.schedule.presentation.states

import com.example.schedule.presentation.model.SubjectUi

sealed class ScheduleState {
    data object Loading : ScheduleState()
    data class Success(val subjects: List<SubjectUi>) : ScheduleState()
    data class Error(val message: String?) : ScheduleState()
}