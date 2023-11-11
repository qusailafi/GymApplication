package com.example.myapplication.di

import com.example.myapplication.BuildConfig
import com.example.myapplication.data.local.GymDataBase
import com.example.myapplication.data.local.GymsDao
import com.example.myapplication.application.MyApp

import com.example.myapplication.data.remote.ApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(90, TimeUnit.SECONDS)
            .writeTimeout(90, TimeUnit.SECONDS)
            .connectTimeout(90, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL).build()
    }

    @Provides

    @Singleton

    fun provideDataBase(): GymDataBase {
        return GymDataBase.buildDataBase(MyApp.appContext)
    }

    @Provides
    @Singleton
    fun provideGymDao(db: GymDataBase): GymsDao {
        return db.getGymDao()
    }

    @Singleton
    @Provides
    fun provideApiEndPoints(retrofit: Retrofit): ApiServices {
        return retrofit.create(ApiServices::class.java)
    }
}