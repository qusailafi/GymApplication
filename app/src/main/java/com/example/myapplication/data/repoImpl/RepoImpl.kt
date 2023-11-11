package com.example.myapplication.data.repoImpl

import com.example.gymapplication.utils.Resource
import com.example.myapplication.data.local.GymsDao
import com.example.myapplication.data.remote.ApiServices
import com.example.myapplication.domain.model.GymsResponseItem
import com.example.myapplication.domain.repo.GymRepo
import com.example.myapplication.utils.NetworkUtils
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepoImpl(val apiServices: ApiServices,val gymsDao: GymsDao) :  GymRepo {
    override suspend fun getGyms(): Flow<Resource<List<GymsResponseItem>>> =
        flow {
            if (NetworkUtils.isNetworkAvailable()) {
                try {
                    val response = apiServices.getGyms()

                    if (response.isSuccessful) {
                        val body = response.body()
                        if (body != null) {
                            gymsDao.addAllGyms(body)
                            emit(Resource.success(body ) )

                        }else{
                            emit(Resource.error(data = gymsDao.getAllGyms(), "Something went wrong, try again later") )

                        }
                    } else {

                         emit(Resource.error(data = gymsDao.getAllGyms(), "Something went wrong, try again later") )

                    }


                } catch (e: Exception) {

                    emit(Resource.error(data = gymsDao.getAllGyms(), "Something went wrong, try again later") )


                }
            } else {
                 emit(Resource.networkError(data = gymsDao.getAllGyms()) )
            }

        }


}