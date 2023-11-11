package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.repo.GymRepo
import javax.inject.Inject

class GymsUseCase @Inject constructor(val repo: GymRepo) {
    suspend operator fun invoke()=repo.getGyms()
}