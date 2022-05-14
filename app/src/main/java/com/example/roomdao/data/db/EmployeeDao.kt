package com.example.roomdao.data.db

import androidx.room.*
import com.example.roomdao.data.models.departmentmember.DepartmentMember
import com.example.roomdao.data.models.departmentmember.employees.EmployeeContract

@Dao
interface EmployeeDao {

    @Query("SELECT * FROM ${EmployeeContract.TABLE_NAME}")
    suspend fun getAllEmployees(): List<DepartmentMember.Employee>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addEmployee(employee: List<DepartmentMember.Employee>)

    @Query("SELECT * FROM ${EmployeeContract.TABLE_NAME} WHERE ${EmployeeContract.Columns.ID} = :employeeId")
    suspend fun getEmployeeById(employeeId: Int): DepartmentMember.Employee?

    @Query("SELECT * FROM ${EmployeeContract.TABLE_NAME} WHERE ${EmployeeContract.Columns.DEPARTMENT_ID} = :departmentId")
    suspend fun getEmployeesByDepartment(departmentId: Int): List<DepartmentMember.Employee>

    @Update
    suspend fun updateEmployee(employee: DepartmentMember.Employee)

    @Delete
    suspend fun deleteEmployee(employee: DepartmentMember.Employee)

    @Transaction
    suspend fun insertAndDelete(
        oldEmployee: DepartmentMember.Employee,
        newEmployee: DepartmentMember.Employee) {
        deleteEmployee(oldEmployee)
        addEmployee(listOf(newEmployee))
    }
}