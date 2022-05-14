package com.example.roomdao.data.models.department

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.roomdao.data.models.faculty.Faculty
import com.example.roomdao.data.models.faculty.FacultyContract

@Entity(
    tableName = DepartmentContract.TABLE_NAME,
//    foreignKeys = [
//        ForeignKey(
//            entity = Faculty::class,
//            parentColumns = [FacultyContract.Columns.ID],
//            childColumns = [DepartmentContract.Columns.FACULTY_ID],
//        )
//    ]
)
data class Department(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DepartmentContract.Columns.ID) val id: Int,
    @ColumnInfo(name = DepartmentContract.Columns.FACULTY_ID) val facultyId: String,
    @ColumnInfo(name = DepartmentContract.Columns.NAME) val name: String,
    @ColumnInfo(name = DepartmentContract.Columns.SPERCIALIZATION) val specialization: String,
)
