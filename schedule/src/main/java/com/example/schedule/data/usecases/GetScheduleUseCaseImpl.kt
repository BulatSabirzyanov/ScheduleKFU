package com.example.schedule.data.usecases

import com.example.schedule.data.remote.response.SubjectsResponse
import com.example.schedule.domain.ScheduleRepository
import com.example.schedule.domain.usecases.GetScheduleUseCase
import javax.inject.Inject

class GetScheduleUseCaseImpl @Inject constructor(
    private val repository: ScheduleRepository
) : GetScheduleUseCase {

    override suspend fun getSchedule(
        groupId: String,
    ): SubjectsResponse {
        return repository.getSchedule(groupId)
    }
}
