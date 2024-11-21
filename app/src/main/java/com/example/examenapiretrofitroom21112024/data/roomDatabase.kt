package com.example.examenapiretrofitroom21112024.data

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [PostEntity::class], version = 1)
    abstract class AppDataBase : RoomDatabase() {
        abstract fun myDao(): PostDao
    }