package com.example.common.di.holder

interface ComponentHolder<T : DiComponent> {
    fun get(): T
    fun set(component: T)
}
