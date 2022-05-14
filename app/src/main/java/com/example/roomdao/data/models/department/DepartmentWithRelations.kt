package com.example.roomdao.data.models.department

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomdao.data.models.departmentmember.DepartmentMember
import com.example.roomdao.data.models.departmentmember.discipline.DisciplineContract
import com.example.roomdao.data.models.departmentmember.employees.EmployeeContract

sealed class DepartmentWithRelations {
    data class DepartmentWithEmployees(
        @Embedded
        val department: Department,
        @Relation(
            parentColumn = DepartmentContract.Columns.ID,
            entityColumn = EmployeeContract.Columns.DEPARTMENT_ID
        )
        val employees: List<DepartmentMember.Employee>
    ) : DepartmentWithRelations()

    data class DepartmentWithDisciplines(
        @Embedded
        val department: Department,
        @Relation(
            parentColumn = DepartmentContract.Columns.ID,
            entityColumn = DisciplineContract.Columns.DEPARTMENT_ID
        )
        val disciplines: List<DepartmentMember.Discipline>
    ) : DepartmentWithRelations()
}
