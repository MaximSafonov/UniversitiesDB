package com.example.roomdao.data.models.departmentmember

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.roomdao.data.models.department.Department
import com.example.roomdao.data.models.department.DepartmentContract
import com.example.roomdao.data.models.departmentmember.discipline.DisciplineContract
import com.example.roomdao.data.models.departmentmember.employees.EmployeeContract

sealed class DepartmentMember {
    @Entity(
        tableName = EmployeeContract.TABLE_NAME,
        foreignKeys = [
            ForeignKey(
                entity = Department::class,
                parentColumns = [DepartmentContract.Columns.ID],
                childColumns = [EmployeeContract.Columns.DEPARTMENT_ID],
            )
        ]
    )
    data class Employee(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = EmployeeContract.Columns.ID) val id: Int,
        @ColumnInfo(name = EmployeeContract.Columns.DEPARTMENT_ID) val departmentId: Int,
        @ColumnInfo(name = EmployeeContract.Columns.NAME) val name: String,
        @ColumnInfo(name = EmployeeContract.Columns.SECOND_NAME) val secondName: String,
        @ColumnInfo(name = EmployeeContract.Columns.ROLE) val role: String,
    ) : DepartmentMember()

    @Entity(
        tableName = DisciplineContract.TABLE_NAME,
        foreignKeys = [
            ForeignKey(
                entity = Department::class,
                parentColumns = [DepartmentContract.Columns.ID],
                childColumns = [DisciplineContract.Columns.DEPARTMENT_ID],
            )
        ]
    )
    data class Discipline(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = DisciplineContract.Columns.ID) val id: Int,
        @ColumnInfo(name = DisciplineContract.Columns.DEPARTMENT_ID) val departmentId: Int,
        @ColumnInfo(name = DisciplineContract.Columns.DISCIPLINE_NAME) val name: String,
    ) : DepartmentMember()
}