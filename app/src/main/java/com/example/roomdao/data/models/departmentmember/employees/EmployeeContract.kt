package com.example.roomdao.data.models.departmentmember.employees

object EmployeeContract {
    const val TABLE_NAME = "employees"

    object Columns {
        const val ID = "employee_id"
        const val DEPARTMENT_ID = "employee_departments_id"
        const val NAME = "employee_name"
        const val SECOND_NAME = "employee_second_name"
        const val ROLE = "employee_role"
    }
}