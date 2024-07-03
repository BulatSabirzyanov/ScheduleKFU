package com.example.schedule.presentation.mapper

import com.example.schedule.data.remote.response.Subjects
import com.example.schedule.presentation.model.SubjectUi
import javax.inject.Inject

class SubjectMapper @Inject constructor() {
    fun toUi(listSubjects: List<Subjects>): List<SubjectUi> {
        return listSubjects.map { subject ->
            SubjectUi(
                id = subject.id,
                subjectName = subject.subjectName,
                teacherName = "${subject.teacherLastname} ${subject.teacherFirstname} ${subject.teacherMiddleName}",
                buildingName = subject.buildingName,
                time = "${subject.beginTimeSchedule} - ${subject.endTimeSchedule}"
            )
        }
    }
}