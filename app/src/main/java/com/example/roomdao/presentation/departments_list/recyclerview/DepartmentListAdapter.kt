package com.example.roomdao.presentation.departments_list.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdao.data.models.department.Department
import com.example.roomdao.databinding.CellDepartmentBinding

class DepartmentListAdapter (private val onclick: (id: Int) -> Unit) : RecyclerView.Adapter<DepartmentListAdapter.ViewHolder>() {

    var departments: List<Department> = listOf(
        Department(
            id = 1,
            facultyId = "123",
            name = "Faculty",
            specialization = "Juvenile"
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding: CellDepartmentBinding =
            CellDepartmentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

        return ViewHolder(
            binding.root, binding
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(departments[position])
    }

    override fun getItemCount(): Int = departments.size

    inner class ViewHolder(
        itemView: View,
        private val binding: CellDepartmentBinding
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Department) {
            binding.root.setOnClickListener {
                onclick(item.id)
            }
            binding.departmentName.text = item.name
            binding.departmentSpecialization.text = item.specialization
        }
    }
}