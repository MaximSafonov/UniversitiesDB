package com.example.roomdao.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomdao.data.models.faculty.Faculty
import com.example.roomdao.data.models.faculty.FacultyContract

@Dao
interface FacultyDao {

    @Query("SELECT * FROM ${FacultyContract.TABLE_NAME}")
    suspend fun getAllFaculties(): List<Faculty>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFaculty(faculty: List<Faculty>)

    @Query("SELECT * FROM ${FacultyContract.TABLE_NAME} WHERE ${FacultyContract.Columns.ID} = :facultyId")
    suspend fun getFacultyById(facultyId: Int): Faculty?
}