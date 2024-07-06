package com.example.schedule.domain

import com.example.schedule.data.remote.response.SubjectsResponse

interface ScheduleRepository {

    suspend fun getSchedule(groupId: String) : SubjectsResponse
}