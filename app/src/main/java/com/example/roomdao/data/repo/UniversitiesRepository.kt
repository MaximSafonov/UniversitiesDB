package com.example.roomdao.data.repo

import com.example.roomdao.data.IncorrectFormException
import com.example.roomdao.data.db.Database
import com.example.roomdao.data.models.university.University
import timber.log.Timber

class UniversitiesRepository {
    private val universityDao = Database.databaseInstance.universityDao()

    suspend fun saveUniversity(university: University) {
        if(!isUniversityValid(university)) throw IncorrectFormException()
        universityDao.insertUniversities(listOf(university))
    }

    suspend fun updateUniversity(university: University) {
        if(!isUniversityValid(university)) throw IncorrectFormException()
        universityDao.updateUniversity(university)
    }

    suspend fun removeUniversity(universityId: Int) {
        universityDao.removeUniversityById(universityId)
    }

    suspend fun getUserById(universityId: Int): University? {
        return universityDao.getUniversityById(universityId)
    }

    suspend fun getAllUniversities(): List<University> {
        Timber.d("getAllUniversities")
        return universityDao.getAllUniversities()
    }

    private fun isUniversityValid(university: University): Boolean {
        return university.name.isNotBlank() &&
                university.city.isNotBlank()
    }
}