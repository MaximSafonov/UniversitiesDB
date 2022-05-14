package com.example.roomdao.data.db

import androidx.room.*
import com.example.roomdao.data.models.university.University
import com.example.roomdao.data.models.university.UniversityContract

@Dao
interface UniversityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(universities: List<University>)

    @Delete
    suspend fun delete(university: University)

    @Query("SELECT * FROM ${UniversityContract.TABLE_NAME}")
    suspend fun getAllUniversities(): List<University>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUniversities(universities: List<University>)

    @Query("SELECT * FROM ${UniversityContract.TABLE_NAME} WHERE ${UniversityContract.Columns.ID} = :universityId")
    suspend fun getUniversityById(universityId: Int): University?

    @Update
    suspend fun updateUniversity(university: University)

    @Query("DELETE FROM ${UniversityContract.TABLE_NAME} WHERE ${UniversityContract.Columns.ID} = :universityId")
    suspend fun removeUniversityById(universityId: Int)
}
