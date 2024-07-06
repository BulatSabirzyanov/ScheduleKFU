package com.example.schedule.data.remote

import com.example.schedule.data.remote.response.SubjectsResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ScheduleApi {

    @GET("/e-ksu/PORTAL_PG_MOBILE.get_schedule")
    suspend fun getGroupSchedule(
        @Query("p_name_group") groupId: String,
        @Query("p_stud_year") year: String = "2023",
        @Query("p_stud_semester") semester: String = "2",
    ): SubjectsResponse
}

