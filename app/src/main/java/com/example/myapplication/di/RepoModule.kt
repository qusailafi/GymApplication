package com.example.myapplication.di

   import com.example.myapplication.data.local.GymsDao
   import com.example.myapplication.data.remote.ApiServices
   import com.example.myapplication.data.repoImpl.RepoImpl
   import com.example.myapplication.domain.repo.GymRepo
   import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    fun provideRepo(apiService: ApiServices,gymsDao: GymsDao): GymRepo {
        return RepoImpl(apiService,gymsDao)
    }
}