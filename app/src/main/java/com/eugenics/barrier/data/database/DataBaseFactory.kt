package com.eugenics.barrier.data.database

import android.content.Context
import androidx.room.Room

object DataBaseFactory {

    fun build(context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "appDataBase.db"
        )
            .fallbackToDestructiveMigration()
            .build()

    fun buildFake(context: Context): AppDatabase =
        Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            .fallbackToDestructiveMigration()
            .build()
}