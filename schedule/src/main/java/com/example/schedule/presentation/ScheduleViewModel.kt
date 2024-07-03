package com.example.schedule.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schedule.data.remote.response.Subjects
import com.example.schedule.domain.usecases.GetScheduleUseCase
import com.example.schedule.presentation.mapper.SubjectMapper
import com.example.schedule.presentation.states.ScheduleState
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ScheduleViewModel @Inject constructor(
    private val getScheduleUseCase: GetScheduleUseCase,
    private val mapper: SubjectMapper
) : ViewModel(){

    private val _schedule = MutableStateFlow<ScheduleState>(ScheduleState.Loading)
    val schedule: StateFlow<ScheduleState> = _schedule.asStateFlow()

    private var subjectsList = mutableListOf<Subjects>()


    fun loadSchedule(groupId: String, year: String, semester: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                subjectsList = getScheduleUseCase.getSchedule(groupId,year,semester).subjects.toMutableList()
                Log.d("123456",subjectsList.toString())
                _schedule.emit(ScheduleState.Success(mapper.toUi(subjectsList)))

            }catch (e: CancellationException) {
                throw e
            }catch (e: Exception){
                _schedule.emit(ScheduleState.Error(e.message))
                Log.e("123",e.message.toString())
            }
        }
    }
}