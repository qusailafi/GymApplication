package com.example.myapplication.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "gyms")

data class GymsResponseItem(
    @PrimaryKey
    @ColumnInfo(name = "gym_id")
     val id: Int,
    @ColumnInfo(name = "gym_location")
    @SerializedName("location")
    val location: String,
    @ColumnInfo(name = "gym_name")
    @SerializedName("name")
    val name: String,
    @ColumnInfo(name = "gym_adress")
    @SerializedName("adress")
    val adress:String
)


