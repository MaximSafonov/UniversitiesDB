package com.example.roomdao.data.models.university

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = UniversityContract.TABLE_NAME)
data class University(
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = UniversityContract.Columns.ID) val id: Int,
    @ColumnInfo(name = UniversityContract.Columns.NAME) val name: String,
    @ColumnInfo(name = UniversityContract.Columns.CITY) val city: String,
    @ColumnInfo(name = UniversityContract.Columns.SPECIALIZATION) val specialization: String,
    @ColumnInfo(name = UniversityContract.Columns.RANK) val rank: String,
)
