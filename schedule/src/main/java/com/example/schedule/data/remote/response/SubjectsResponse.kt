package com.example.schedule.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SubjectsResponse(
    @SerialName("subjects")
    val subjects: List<Subjects>
)