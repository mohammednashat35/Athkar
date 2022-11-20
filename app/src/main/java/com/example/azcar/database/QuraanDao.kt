package com.example.azcar.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface QuraanDao {

    @Insert
    suspend fun insert(azcarEntity: QuraanEntity)

    @Update
    suspend fun update(azcarEntity: QuraanEntity)

    @Query("DELETE From azcar_table ")
    suspend fun clear()

    @Query("SELECT * FROM azcar_table WHERE zicerId = :key")
    suspend fun get(key: Long): QuraanEntity

    @Query("SELECT * From azcar_table ORDER By zicerId DESC LIMIT 1")
    suspend fun getLastZicer(): QuraanEntity?

    @Query("SELECT * From Azcar_table ORDER By zicerId DESC ")
    fun getAllAzcar(): LiveData<List<QuraanEntity>>

}