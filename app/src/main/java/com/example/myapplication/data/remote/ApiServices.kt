package com.example.myapplication.data.remote
 import com.example.myapplication.domain.model.GymsResponseItem
 import retrofit2.Response
import retrofit2.http.GET
interface ApiServices {
    @GET("gyms.json")
    suspend fun getGyms(): Response<List<GymsResponseItem>>
}