package com.example.schedule.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subjects")
data class SubjectList(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "semester")
    val semester: Int,

    @ColumnInfo(name = "year")
    val year: Int,

    @ColumnInfo(name = "subject_name")
    val subjectName: String,

    @ColumnInfo(name = "subject_id")
    val subjectId: Int,

    @ColumnInfo(name = "start_day_schedule")
    val startDaySchedule: String,

    @ColumnInfo(name = "finish_day_schedule")
    val finishDaySchedule: String,

    @ColumnInfo(name = "day_week_schedule")
    val dayWeekSchedule: Int,

    @ColumnInfo(name = "type_week_schedule")
    val typeWeekSchedule: Int,

    @ColumnInfo(name = "note_schedule")
    val noteSchedule: String,

    @ColumnInfo(name = "time_interval_id")
    val timeIntervalId: Int,

    @ColumnInfo(name = "total_time_schedule")
    val totalTimeSchedule: String,

    @ColumnInfo(name = "begin_time_schedule")
    val beginTimeSchedule: String,

    @ColumnInfo(name = "end_time_schedule")
    val endTimeSchedule: String,

    @ColumnInfo(name = "teacher_id")
    val teacherId: Int,

    @ColumnInfo(name = "teacher_lastname")
    val teacherLastname: String,

    @ColumnInfo(name = "teacher_firstname")
    val teacherFirstname: String,

    @ColumnInfo(name = "teacher_middlename")
    val teacherMiddleName: String,

    @ColumnInfo(name = "num_auditorium_schedule")
    val numAuditoriumSchedule: String,

    @ColumnInfo(name = "building_name")
    val buildingName: String,

    @ColumnInfo(name = "building_id")
    val buildingId: Int,

    @ColumnInfo(name = "group_list")
    val groupList: String,

    @ColumnInfo(name = "url_list")
    val urlList: String,

    @ColumnInfo(name = "subject_kind_name")
    val subjectKindName: String
)