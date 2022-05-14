package com.example.roomdao.presentation.department_member_list.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.roomdao.R
import com.example.roomdao.data.models.departmentmember.DepartmentMember
import com.example.roomdao.databinding.CellDisciplineBinding
import com.example.roomdao.databinding.CellEmployeeBinding
import java.lang.IllegalArgumentException

class DepartmentMemberAdapter :
    ListAdapter<DepartmentMember, DepartmentMemberViewHolder>(DepartmentMemberDiffCallBack()) {

    var itemClickListener: ((view: View, item: DepartmentMember, position: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepartmentMemberViewHolder {
        return when (viewType) {
            R.layout.cell_discipline -> DepartmentMemberViewHolder.DisciplineViewHolder(
                CellDisciplineBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            R.layout.cell_employee -> DepartmentMemberViewHolder.EmployeeViewHolder(
                CellEmployeeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: DepartmentMemberViewHolder, position: Int) {
        holder.itemClickListener = itemClickListener

        val item = getItem(position)
        when (holder) {
            is DepartmentMemberViewHolder.DisciplineViewHolder -> holder.bind(item as DepartmentMember.Discipline)
            is DepartmentMemberViewHolder.EmployeeViewHolder -> holder.bind(item as DepartmentMember.Employee)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DepartmentMember.Employee -> R.layout.cell_employee
            is DepartmentMember.Discipline -> R.layout.cell_discipline
        }
    }


    private class DepartmentMemberDiffCallBack : DiffUtil.ItemCallback<DepartmentMember>() {
        override fun areItemsTheSame(
            oldItem: DepartmentMember,
            newItem: DepartmentMember
        ): Boolean {
            return when {
                oldItem is DepartmentMember.Discipline && newItem is DepartmentMember.Discipline -> true
                oldItem is DepartmentMember.Employee && newItem is DepartmentMember.Employee -> true
                else -> false
            }
        }

        override fun areContentsTheSame(
            oldItem: DepartmentMember,
            newItem: DepartmentMember
        ): Boolean {
            return oldItem == newItem
        }

    }
}