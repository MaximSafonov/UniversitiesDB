package com.example.roomdao.data.repo

import com.example.roomdao.data.IncorrectFormException
import com.example.roomdao.data.db.Database
import com.example.roomdao.data.models.department.Department

class DepartmentRepository {
    private val departmentDao = Database.databaseInstance.departmentDao()

    val baseDepartment = Department(
        name = "Департамент № 1",
        facultyId = "Следственный факультет",
        specialization = "Юрист",
        id = 1
    )

    suspend fun saveDepartment(department: Department){
        if (!isDepartmentValid(department)) throw IncorrectFormException()
        departmentDao.saveDepartment(department)
    }

    suspend fun delete(department: Department) {
        departmentDao.delete(department)
    }

    suspend fun update(department: Department){
        departmentDao.update(department)
    }

    suspend fun getAllDepartments(): List<Department> {
        return departmentDao.getAllDepartments()
    }

    suspend fun getDepartmentById(departmentId: Int) {
        departmentDao.getDepartmentById(departmentId)
    }

    private fun isDepartmentValid(department: Department): Boolean{
        return department.name.isNotBlank()
    }

}