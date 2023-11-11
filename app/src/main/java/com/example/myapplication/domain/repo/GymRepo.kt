package com.example.myapplication.domain.repo

import com.example.gymapplication.utils.Resource
import com.example.myapplication.domain.model.GymsResponseItem


interface GymRepo {

    suspend fun getGyms( ): kotlinx.coroutines.flow.Flow<Resource<List<GymsResponseItem>>>
}