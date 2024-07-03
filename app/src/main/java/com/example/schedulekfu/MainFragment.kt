package com.example.schedulekfu

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.common.lazyUnsafe
import com.example.scheduleapp.R
import com.example.scheduleapp.databinding.FragmentMainBinding
import com.example.schedulekfu.di.AppComponentHolder
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import dagger.Lazy
import javax.inject.Inject


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private var currentScreenIndex: Int? = null
    private var currentScreen: FragmentScreen = Screens.SearchSchedule()

    @Inject
    lateinit var localRouter: Lazy<Router>

    @Inject
    lateinit var navigatorHolder: Lazy<NavigatorHolder>

    private val navigator by lazyUnsafe {
        AppNavigator(requireActivity(), R.id.top_cont)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AppComponentHolder.get().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        currentScreenIndex = savedInstanceState?.getInt(SCREEN_KEY)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null || currentScreenIndex == SEARCH_SCHEDULE_SCREEN) {
            localRouter.get().replaceScreen(currentScreen)
        }
    }

    override fun onResume() {
        navigatorHolder.get().setNavigator(navigator)
        super.onResume()
    }

    override fun onPause() {
        navigatorHolder.get().removeNavigator()
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        currentScreenIndex?.let { outState.putInt(SCREEN_KEY, it) }
    }

    companion object {
        private const val SCREEN_KEY = "screen"
        private const val SEARCH_SCHEDULE_SCREEN = 0
        private const val SCHEDULE_SCREEN = 1
        private const val SCHEDULE_DETAIL_SCREEN = 2
    }
}