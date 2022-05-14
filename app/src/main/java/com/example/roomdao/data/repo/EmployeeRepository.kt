package com.example.roomdao.data.repo

import com.example.roomdao.data.IncorrectFormException
import com.example.roomdao.data.db.Database
import com.example.roomdao.data.models.departmentmember.DepartmentMember

class EmployeeRepository: Repository {

    private val employeeDao = Database.databaseInstance.employeeDao()

    private val listEmployees = listOf(
        DepartmentMember.Employee(
            id = 1,
            name = "Сотрудничек",
            secondName = "Хорошенький",
            role = "Главненький",
            departmentId = 1
        ),
        DepartmentMember.Employee(
            id = 2,
            name = "Сотрудничек2",
            secondName = "Хорошенький2",
            role = "Главненький2",
            departmentId = 1
        ),

    )

    suspend fun saveBase() {
        employeeDao.addEmployee(listEmployees)
    }

    override suspend fun save(item: DepartmentMember) {
        if (!isEmployeeValid(item as DepartmentMember.Employee)) throw IncorrectFormException()
        employeeDao.addEmployee(listOf(item as DepartmentMember.Employee))
    }

    override suspend fun update(item: DepartmentMember) {
        employeeDao.updateEmployee(item as DepartmentMember.Employee)
    }

    override suspend fun delete(item: DepartmentMember) {
        employeeDao.deleteEmployee(item as DepartmentMember.Employee)
    }

    override suspend fun getAllDepartmentMembers(): List<DepartmentMember> {
        return employeeDao.getAllEmployees()
    }

    suspend fun getEmployeeById(employeeId: Int): DepartmentMember.Employee? {
        return employeeDao.getEmployeeById(employeeId)
    }

    suspend fun getEmployeesByDepartment(departmentId: Int): List<DepartmentMember.Employee> {
        return employeeDao.getEmployeesByDepartment(departmentId)
    }



    private fun isEmployeeValid(employee: DepartmentMember.Employee): Boolean {
        return employee.name.isNotBlank()
    }
}