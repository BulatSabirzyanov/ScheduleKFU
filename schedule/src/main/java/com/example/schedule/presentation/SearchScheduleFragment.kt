package com.example.schedule.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.schedule.databinding.FragmentSearchScheduleBinding
import com.example.schedule.di.ScheduleComponentHolder
import com.example.schedule.utils.ViewModelFactory
import javax.inject.Inject


class SearchScheduleFragment : Fragment() {

    private lateinit var binding: FragmentSearchScheduleBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: SearchScheduleViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        ScheduleComponentHolder().get().inject(this)
        super.onAttach(context)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchScheduleBinding.inflate(layoutInflater)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            btnSearch.setOnClickListener {
                val groupId = eTGroupId.text.toString()
                viewModel.navigateToViewPager(groupId)
            }
        }
    }

}