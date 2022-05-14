package com.example.roomdao.data.db

import androidx.room.*
import com.example.roomdao.data.models.department.Department
import com.example.roomdao.data.models.department.DepartmentContract
import com.example.roomdao.data.models.university.UniversityContract

@Dao
interface DepartmentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveDepartment(item: Department)

    @Query("SELECT * FROM ${DepartmentContract.TABLE_NAME}")
    suspend fun getAllDepartments(): List<Department>

    @Query("SELECT * FROM ${DepartmentContract.TABLE_NAME} WHERE ${DepartmentContract.Columns.ID} = :departmentId")
    suspend fun getDepartmentById(departmentId: Int): Department?

    @Delete
    suspend fun delete(department: Department)

    @Update
    suspend fun update(department: Department)
}