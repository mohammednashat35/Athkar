package com.example.azcar.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Azcar_table")

data class QuraanEntity(
    @PrimaryKey(autoGenerate = true)
    var zicerId: Long = 0L,

    val zicerText: String,

    val howMany: Int,
)
