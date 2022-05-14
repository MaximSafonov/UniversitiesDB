package com.example.roomdao.data.repo

import androidx.room.Dao
import com.example.roomdao.data.models.departmentmember.DepartmentMember

interface Repository {
    suspend fun save(item: DepartmentMember)
    suspend fun update(item: DepartmentMember)
    suspend fun delete(item: DepartmentMember)
    suspend fun getAllDepartmentMembers(): List<DepartmentMember>
}