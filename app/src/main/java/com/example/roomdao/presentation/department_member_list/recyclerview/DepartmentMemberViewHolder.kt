package com.example.roomdao.presentation.department_member_list.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.roomdao.data.models.departmentmember.DepartmentMember
import com.example.roomdao.databinding.CellDisciplineBinding
import com.example.roomdao.databinding.CellEmployeeBinding

sealed class DepartmentMemberViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    var itemClickListener: ((view: View, item: DepartmentMember, position: Int) -> Unit)? = null

    class EmployeeViewHolder(private val binding: CellEmployeeBinding) : DepartmentMemberViewHolder(binding) {
        fun bind(item: DepartmentMember.Employee) {
            binding.employeeName.text = item.name
            binding.employeeSecondName.text = item.secondName
            binding.employeeRole.text = item.role

        }
    }

    class DisciplineViewHolder(private val binding: CellDisciplineBinding) : DepartmentMemberViewHolder(binding) {
        fun bind(item: DepartmentMember.Discipline) {
            binding.disciplineName.text = item.name
            binding.disciplineDepartmentsId.text = item.departmentId.toString()
            binding.disciplineId.text = item.id.toString()
        }
    }
}