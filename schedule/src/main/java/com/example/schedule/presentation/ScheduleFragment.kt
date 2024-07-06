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
import com.example.schedule.presentation.adapter.VerticalSpaceItemDecoration
import com.example.schedule.presentation.model.SubjectUi
import com.example.schedule.presentation.states.ScheduleState
import com.example.schedule.utils.ViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject


class ScheduleFragment : Fragment() {

    private lateinit var groupId: String
    private  var position: Int? = 0
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
            groupId = it.getString(GROUP_ID, "")
            position  = it.getInt(POSITION, 0)
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
        position?.let { viewModel.loadSchedule(groupId, it) }
        val spacingDp = 10f
        val itemVerticalDecoration = VerticalSpaceItemDecoration(spacingDp)
        with(binding) {
            recycler.adapter = scheduleAdapter
            recycler.addItemDecoration(itemVerticalDecoration)
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
        private const val POSITION =  "position"

        fun newInstance(position: Int, groupId: String): ScheduleFragment =
            ScheduleFragment().apply {
                arguments = Bundle().apply {
                    putInt(POSITION, position)
                    putString(GROUP_ID, groupId)
                }
            }
    }

}