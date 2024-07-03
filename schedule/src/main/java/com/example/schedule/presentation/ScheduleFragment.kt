package com.example.schedule.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.schedule.databinding.FragmentScheduleBinding
import com.example.schedule.di.ScheduleComponentHolder
import com.example.schedule.presentation.adapter.ScheduleAdapter
import com.example.schedule.presentation.model.SubjectUi
import com.example.schedule.presentation.states.ScheduleState
import com.example.schedule.utils.ViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject


class ScheduleFragment : Fragment() {

    private lateinit var groupId: String
    private lateinit var year: String
    private lateinit var semester: String

    private lateinit var binding: FragmentScheduleBinding

    private var scheduleAdapter = ScheduleAdapter()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: ScheduleViewModel by viewModels { viewModelFactory }


    override fun onAttach(context: Context) {
        ScheduleComponentHolder().get().inject(this)
        super.onAttach(context)
    }

    private fun initFieldFromBundle() {
        arguments?.let {
            groupId = it.getString(GROUP_ID, DEFAULT_GROUP_ID)
            year = it.getString(YEAR, DEFAULT_YEAR)
            semester = it.getString(SEMESTER, DEFAULT_SEMESTER)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initFieldFromBundle()
        binding = FragmentScheduleBinding.inflate(layoutInflater)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadSchedule(groupId, year, semester)
        with(binding) {
            recycler.adapter = scheduleAdapter
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.schedule.collect { state ->
                    when (state) {
                        is ScheduleState.Loading -> handleLoading()
                        is ScheduleState.Success -> handleSuccess(state.subjects)
                        is ScheduleState.Error -> handleError(state.message)
                    }

                }
            }
        }

    }

    private fun handleLoading() {
        binding.run {
            progressBar.visibility = View.VISIBLE
        }
    }

    private fun handleSuccess(subjectList: List<SubjectUi>) {
        binding.run {
            progressBar.visibility = View.GONE
            recycler.visibility = View.VISIBLE
        }
        scheduleAdapter.submitList(subjectList)
    }

    private fun handleError(message: String?) {
        Toast.makeText(context, message ?: "An unknown error occurred", Toast.LENGTH_LONG).show()
    }


    companion object {

        private const val GROUP_ID = "groupId"
        private const val YEAR = "year"
        private const val SEMESTER = "semester"

        private const val DEFAULT_GROUP_ID = "11-109"
        private const val DEFAULT_YEAR = "2024"
        private const val DEFAULT_SEMESTER = "2"

        fun newInstance(groupId: String, year: String, semester: String): ScheduleFragment =
            ScheduleFragment().apply {
                arguments = Bundle().apply {
                    putString("GROUP_ID", groupId)
                    putString("year", year)
                    putString("semester", semester)
                }
            }
    }

}