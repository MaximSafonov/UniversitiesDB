package com.example.roomdao.data.db

import androidx.room.*
import com.example.roomdao.data.models.departmentmember.DepartmentMember
import com.example.roomdao.data.models.departmentmember.discipline.DisciplineContract

@Dao
interface DisciplineDao {

    @Query("SELECT * FROM ${DisciplineContract.TABLE_NAME}")
    suspend fun getAllDisciplines(): List<DepartmentMember.Discipline>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addDiscipline(discipline: DepartmentMember.Discipline)

    @Update
    suspend fun update(discipline: DepartmentMember.Discipline)

    @Delete
    suspend fun delete(discipline: DepartmentMember.Discipline)

    @Query("SELECT * FROM ${DisciplineContract.TABLE_NAME} WHERE ${DisciplineContract.Columns.ID} = :disciplineId")
    suspend fun getDisciplineById(disciplineId: Int): DepartmentMember.Discipline?
}