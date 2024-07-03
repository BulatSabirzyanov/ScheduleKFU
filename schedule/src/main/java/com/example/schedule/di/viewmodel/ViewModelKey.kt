package com.example.schedule.di.viewmodel

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * @author b.sabirzyanov
 */
@MapKey
annotation class ViewModelKey(val viewModelClass: KClass<out ViewModel>)