package com.example.schedule.data

import com.example.schedule.data.remote.ScheduleApi
import com.example.schedule.data.remote.response.SubjectsResponse
import com.example.schedule.domain.ScheduleRepository
import javax.inject.Inject

class ScheduleRepositoryImpl @Inject constructor(
    private val remote: ScheduleApi,
//    private val local: ScheduleListDao,
) : ScheduleRepository {
    override suspend fun getSchedule(
        groupId: String,
        year: String,
        semester: String
    ): SubjectsResponse {
        return remote.getGroupSchedule(groupId, year, semester)
    }
}