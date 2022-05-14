package com.example.roomdao.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdao.data.models.departmentmember.DepartmentMember
import com.example.roomdao.data.repo.EmployeeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DepartmentMemberViewModel : ViewModel() {
    private val employeeRepo = EmployeeRepository()

    private val _employeeList = MutableStateFlow<List<DepartmentMember.Employee>>(emptyList())
    val employeeList = _employeeList.asStateFlow()

    init {
        viewModelScope.launch {
            employeeRepo.saveBase()
        }
    }

    fun loadEmployees(departmentId: Int) {
        viewModelScope.launch {
            _employeeList.value = employeeRepo.getEmployeesByDepartment(departmentId)
        }
    }
}