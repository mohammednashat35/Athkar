package com.example.azcar.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [QuraanEntity::class], version = 1, exportSchema = false)
abstract class DataBase (): RoomDatabase() {

    abstract val dataSource: QuraanDao

    companion object{
        @Volatile
        private var Instance:DataBase? = null

        fun getInstance(context: Context):DataBase{

            synchronized(this){

                var instance = Instance

                if (instance == null){
                    instance = Room.databaseBuilder(context.applicationContext,
                    DataBase::class.java,
                    "azkar.db")
                        .fallbackToDestructiveMigration()
                        .build()
                    Instance = instance
                }
            return instance
            }
        }

    }
}