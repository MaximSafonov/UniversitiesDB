package com.example.roomdao.presentation.department_member_list

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.roomdao.R
import com.example.roomdao.databinding.FragmentDepartmentmemberListBinding
import com.example.roomdao.presentation.BaseFragment
import com.example.roomdao.presentation.department_member_list.recyclerview.DepartmentMemberAdapter
import com.example.roomdao.presentation.viewmodels.DepartmentMemberViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class DepartmentMemberFragment: BaseFragment<FragmentDepartmentmemberListBinding>() {

    private var id: Int? = null

    private val viewModel: DepartmentMemberViewModel by viewModels()

    private var departmentMemberAdapter: DepartmentMemberAdapter? = null

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDepartmentmemberListBinding {
        return FragmentDepartmentmemberListBinding.inflate(inflater, container, false)
    }

    @SuppressLint("ResourceAsColor", "NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()

        id = arguments?.getInt("id") ?: 0
        viewModel.loadEmployees(id ?: 0)

        viewModel.employeeList.onEach { list ->
            departmentMemberAdapter?.submitList(list)
            departmentMemberAdapter?.notifyDataSetChanged()
        }.launchIn(lifecycleScope)

        binding.appBar.toolbar.apply {
            title = "Состав департамента"
            textAlignment = View.TEXT_ALIGNMENT_CENTER
            setTitleTextColor(R.color.black)
        }
    }

    private fun initList() {
        departmentMemberAdapter = DepartmentMemberAdapter()
        binding.departmentMemberList.apply {
            adapter = departmentMemberAdapter
            setHasFixedSize(true)
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

}