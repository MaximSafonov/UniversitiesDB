package com.example.roomdao.data.models.faculty

import androidx.room.*
import com.example.roomdao.data.models.university.University
import com.example.roomdao.data.models.university.UniversityContract

@TypeConverters(FacultySpecConverter::class)
@Entity(
    tableName = FacultyContract.TABLE_NAME,
    foreignKeys = [ForeignKey(
        entity = University::class,
        parentColumns = [UniversityContract.Columns.ID],
        childColumns = [FacultyContract.Columns.UNIVERSITY_ID],
    )]
)
data class Faculty(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = FacultyContract.Columns.ID) val id: Int,
    @ColumnInfo(name = FacultyContract.Columns.UNIVERSITY_ID) val universityId: Int,
    @ColumnInfo(name = FacultyContract.Columns.NAME) val name: String,
    @ColumnInfo(name = FacultyContract.Columns.SPECIALIZATION) val specialization: FacultySpecialization,
)

enum class FacultySpecialization {
    Law,
    Math,
    Philosophy,
    Chemistry,
}