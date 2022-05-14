package com.example.roomdao.data.repo

import com.example.roomdao.data.IncorrectFormException
import com.example.roomdao.data.db.Database
import com.example.roomdao.data.models.departmentmember.DepartmentMember

class DisciplineRepository: Repository {
    private val disciplineDao = Database.databaseInstance.disciplineDao()

    override suspend fun save(item: DepartmentMember) {
        if (!isDisciplineValid(item as DepartmentMember.Discipline)) throw IncorrectFormException()
        disciplineDao.addDiscipline(item as DepartmentMember.Discipline)
    }

    override suspend fun update(item: DepartmentMember) {
        disciplineDao.update(item as DepartmentMember.Discipline)
    }

    override suspend fun delete(item: DepartmentMember) {
        disciplineDao.delete(item as DepartmentMember.Discipline)
    }

    override suspend fun getAllDepartmentMembers(): List<DepartmentMember> {
        return disciplineDao.getAllDisciplines()
    }

    private fun isDisciplineValid(discipline: DepartmentMember.Discipline): Boolean {
        return discipline.name.isNotBlank()
    }

}