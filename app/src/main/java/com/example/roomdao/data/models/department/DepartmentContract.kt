package com.example.roomdao.data.models.department

object DepartmentContract {
    const val TABLE_NAME = "departments"

    object Columns{
        const val ID = "department_id"
        const val FACULTY_ID = "faculty_id"
        const val NAME = "department_name"
        const val SPERCIALIZATION = "department_specialization"
    }
}