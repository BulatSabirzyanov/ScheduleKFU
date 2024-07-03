package com.example.schedule.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.schedule.databinding.ScheduleListItemBinding
import com.example.schedule.presentation.model.SubjectUi


class ScheduleAdapter(
//    private val listener: OnItemClickListener
) : ListAdapter<SubjectUi, ScheduleAdapter.ScheduleViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ScheduleListItemBinding.inflate(inflater, parent, false)
        return ScheduleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ScheduleViewHolder(private val binding: ScheduleListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SubjectUi) {
            with(binding) {
                tVSubjectName.text = item.subjectName
                tVTeacherName.text = item.teacherName
                tVBuildingName.text = item.buildingName
                tVTotalTimeSchedule.text = item.time
            }
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<SubjectUi>() {
        override fun areItemsTheSame(oldItem: SubjectUi, newItem: SubjectUi): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: SubjectUi,
            newItem: SubjectUi
        ): Boolean {
            return oldItem == newItem
        }
    }
}