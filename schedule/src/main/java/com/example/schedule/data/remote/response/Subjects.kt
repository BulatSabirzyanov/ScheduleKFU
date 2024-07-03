package com.example.schedule.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Subjects (

    @SerialName("id")
    val id: Int,

    @SerialName("semester")
    val semester: Int,

    @SerialName("year")
    val year: Int,

    @SerialName("subject_name")
    val subjectName: String,

    @SerialName("subject_id")
    val subjectId: Int,

    @SerialName("start_day_schedule")
    val startDaySchedule: String,

    @SerialName("finish_day_schedule")
    val finishDaySchedule: String,

    @SerialName("day_week_schedule")
    val dayWeekSchedule: Int,

    @SerialName("type_week_schedule")
    val typeWeekSchedule: Int,

    @SerialName("note_schedule")
    val noteSchedule: String,

    @SerialName("time_interval_id")
    val timeIntervalId: Int,

    @SerialName("total_time_schedule")
    val totalTimeSchedule: String,

    @SerialName("begin_time_schedule")
    val beginTimeSchedule: String,

    @SerialName("end_time_schedule")
    val endTimeSchedule: String,

    @SerialName("teacher_id")
    val teacherId: Int,

    @SerialName("teacher_lastname")
    val teacherLastname: String,

    @SerialName("teacher_firstname")
    val teacherFirstname: String,

    @SerialName("teacher_middlename")
    val teacherMiddleName: String,

    @SerialName("num_auditorium_schedule")
    val numAuditoriumSchedule: String,

    @SerialName("building_name")
    val buildingName: String,

    @SerialName("building_id")
    val buildingId: Int,

    @SerialName("group_list")
    val groupList: String,

    @SerialName("url_list")
    val urlList: String,

    @SerialName("subject_kind_name")
    val subjectKindName: String
)
