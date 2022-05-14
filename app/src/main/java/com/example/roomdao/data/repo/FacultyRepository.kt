package com.example.roomdao.data.repo

import com.example.roomdao.data.IncorrectFormException
import com.example.roomdao.data.db.Database
import com.example.roomdao.data.models.faculty.Faculty
import timber.log.Timber

class FacultyRepository {

    private val facultyDao = Database.databaseInstance.facultyDao()

    suspend fun saveFaculty(faculty: Faculty) {
        if(isFacultyValid(faculty).not()) throw IncorrectFormException()
        facultyDao.addFaculty(listOf(faculty))
    }

    suspend fun getFacultyById(facultyId: Int): Faculty? {
        return facultyDao.getFacultyById(facultyId)
    }

    suspend fun getAllFaculties(): List<Faculty> {
        Timber.d("getAllUniversities")
        return facultyDao.getAllFaculties()
    }

    private fun isFacultyValid(faculty: Faculty): Boolean {
        return faculty.name.isNotBlank()
    }

}