package com.example.roomdao.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdao.data.models.faculty.Faculty
import com.example.roomdao.data.repo.FacultyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FacultiesViewModel: ViewModel() {

    private val _facultiesList = MutableStateFlow<List<Faculty>>(emptyList())
    val facultiesList = _facultiesList.asStateFlow()

    private val repository = FacultyRepository()

    init {
        viewModelScope.launch {
            _facultiesList.value = repository.getAllFaculties()
        }
    }
}