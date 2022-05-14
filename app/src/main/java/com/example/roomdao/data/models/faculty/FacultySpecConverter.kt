package com.example.roomdao.data.models.faculty

import androidx.room.TypeConverter

class FacultySpecConverter {
    @TypeConverter
    fun convertStatusToString(specialization: FacultySpecialization): String = specialization.name

    @TypeConverter
    fun convertStringToStatus(specializationString: String): FacultySpecialization =
        FacultySpecialization.valueOf(specializationString)

}