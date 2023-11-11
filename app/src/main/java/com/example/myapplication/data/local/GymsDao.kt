package com.example.myapplication.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.domain.model.GymsResponseItem

@Dao
interface GymsDao {
    @Query("SELECT * FROM gyms")
    suspend fun getAllGyms(): List<GymsResponseItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllGyms(allGyms: List<GymsResponseItem>)
}