package com.example.gymapplication.presenter.viewmodels

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gymapplication.utils.Resource
import com.example.myapplication.domain.model.GymsResponseItem
import com.example.myapplication.domain.usecase.GymsUseCase
import com.example.myapplication.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GymsViewModel @Inject constructor(val useCse: GymsUseCase) : ViewModel() {
       var state by mutableStateOf(
        Resource(
            status = Status.LOADING,
            data = ArrayList<GymsResponseItem>() ,
            message = ""
        )

    )

    init {
        getGyms()
    }


    fun getGyms() {
        viewModelScope.launch {
            useCse().collect {
                state = state.copy(data = it?.data as ArrayList<GymsResponseItem>?, status = it.status, message = it.message)

            }
        }
    }
}

