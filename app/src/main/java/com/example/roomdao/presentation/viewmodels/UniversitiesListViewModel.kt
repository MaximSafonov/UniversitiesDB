package com.example.roomdao.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdao.data.repo.UniversitiesRepository
import com.example.roomdao.data.models.university.University
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UniversitiesListViewModel : ViewModel() {

    private val repository = UniversitiesRepository()

    private val _users: MutableStateFlow<List<University>> = MutableStateFlow(emptyList())
    val users = _users.asStateFlow()

    fun loadList() {
        viewModelScope.launch {
            _users.value = repository.getAllUniversities()
        }
    }

    fun addUniversity(university: University) {
        viewModelScope.launch {
            repository.saveUniversity(university)
            loadList()
        }
    }

    fun deleteUniversity(university: University) {
        viewModelScope.launch {
            repository.removeUniversity(university.id)
            loadList()
        }
    }
}