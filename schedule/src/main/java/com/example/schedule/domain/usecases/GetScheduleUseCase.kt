package com.example.schedule.domain.usecases

import com.example.schedule.data.remote.response.SubjectsResponse

interface GetScheduleUseCase {

    suspend fun getSchedule(groupId: String) : SubjectsResponse
}