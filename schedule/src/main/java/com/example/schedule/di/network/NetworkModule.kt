package com.example.schedule.di.network

import com.example.schedule.data.remote.ScheduleApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

@Module
class NetworkModule {
    @Provides
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
        coerceInputValues = true
    }

    @Provides
    @OptIn(ExperimentalSerializationApi::class)
    fun provideScheduleApiService(
        json: Json
    ): ScheduleApi {
        return Retrofit.Builder()
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .baseUrl("https://shelly.kpfu.ru")
            .build()
            .create(ScheduleApi::class.java)
    }
}