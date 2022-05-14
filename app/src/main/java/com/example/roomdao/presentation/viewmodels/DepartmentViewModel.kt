package com.example.roomdao.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdao.data.models.department.Department
import com.example.roomdao.data.repo.DepartmentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DepartmentViewModel: ViewModel() {

    private val _departmentList = MutableStateFlow<List<Department>>(emptyList())
    val departmentList = _departmentList.asStateFlow()

    private val repository = DepartmentRepository()

    init {
        viewModelScope.launch {
            _departmentList.value = repository.getAllDepartments()
            _departmentList.value = listOf(repository.baseDepartment)
            repository.saveDepartment(repository.baseDepartment)
        }
    }

}