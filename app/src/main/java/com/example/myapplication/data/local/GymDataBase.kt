package com.example.myapplication.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.domain.model.GymsResponseItem

@Database(entities = [GymsResponseItem::class], version = 1)
//@TypeConverters(Convertrs::class)
  abstract class GymDataBase : RoomDatabase() {


    companion object {

        fun buildDataBase(context: Context): GymDataBase {
            return Room.databaseBuilder(
                context.applicationContext,
                GymDataBase::class.java,
                "gymsDataBase"
            ).fallbackToDestructiveMigration().build()
        }

     }
    abstract fun getGymDao(): GymsDao
}