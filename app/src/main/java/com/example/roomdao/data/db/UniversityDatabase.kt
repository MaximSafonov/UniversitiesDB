package com.example.roomdao.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdao.data.models.department.Department
import com.example.roomdao.data.models.departmentmember.DepartmentMember
import com.example.roomdao.data.models.faculty.Faculty
import com.example.roomdao.data.models.university.University

@Database(
    entities = [
        University::class,
        Department::class,
        Faculty::class,
        DepartmentMember.Discipline::class,
        DepartmentMember.Employee::class],
    version = UniversityDatabase.DATABASE_VERSION
)
abstract class UniversityDatabase : RoomDatabase() {

    abstract fun universityDao(): UniversityDao
    abstract fun facultyDao(): FacultyDao
    abstract fun employeeDao(): EmployeeDao
    abstract fun disciplineDao(): DisciplineDao
    abstract fun departmentDao(): DepartmentDao

    companion object {
        const val DATABASE_VERSION = 2
        const val DATABASE_NAME = "University Database"
    }
}