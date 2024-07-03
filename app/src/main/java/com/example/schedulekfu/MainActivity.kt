package com.example.schedulekfu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.common.lazyUnsafe
import com.example.scheduleapp.R
import com.example.schedulekfu.Screens.Main
import com.example.scheduleapp.databinding.ActivityMainBinding
import com.example.schedulekfu.di.AppComponentHolder
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import dagger.Lazy
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val navigator by lazyUnsafe { AppNavigator(this, R.id.main_cont) }

    @Inject
    lateinit var navigatorHolder: Lazy<NavigatorHolder>

    @Inject
    lateinit var router: Lazy<Router>

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.get().setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.get().removeNavigator()
        super.onPause()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppComponentHolder.get().inject(this)
        if (savedInstanceState == null) {
            router.get().replaceScreen(Main())
        }
    }
}