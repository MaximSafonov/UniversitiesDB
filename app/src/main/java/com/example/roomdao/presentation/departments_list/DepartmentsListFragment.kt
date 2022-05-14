package com.example.roomdao.presentation.departments_list

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.roomdao.R
import com.example.roomdao.databinding.FragmentDepartmentsBinding
import com.example.roomdao.presentation.BaseFragment
import com.example.roomdao.presentation.departments_list.recyclerview.DepartmentListAdapter
import com.example.roomdao.presentation.viewmodels.DepartmentMemberViewModel
import com.example.roomdao.presentation.viewmodels.DepartmentViewModel
import com.example.roomdao.utils.autoCleared
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class DepartmentsListFragment : BaseFragment<FragmentDepartmentsBinding>() {

    private var departmentAdapter: DepartmentListAdapter by autoCleared<DepartmentListAdapter>()
    private val viewModel: DepartmentViewModel by viewModels()

    @SuppressLint("ResourceAsColor", "NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initList()

        binding.appBar.toolbar.apply {
            title = "Перечень департаментов"
            textAlignment = View.TEXT_ALIGNMENT_CENTER
            setTitleTextColor(R.color.black)
        }

        viewModel.departmentList.onEach { list ->
            departmentAdapter.departments = list
            departmentAdapter.notifyDataSetChanged()
        }.launchIn(lifecycleScope)

    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDepartmentsBinding {
        return FragmentDepartmentsBinding.inflate(inflater, container, false)
    }

    private fun initList() {
        departmentAdapter = DepartmentListAdapter() { id -> navigateTo(id)}

        with(binding.departMentsList) {
            adapter = departmentAdapter
            setHasFixedSize(true)
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }
    
    private fun navigateTo(id: Int) {
        val args = bundleOf("id" to id)
        findNavController().navigate(R.id.action_global_departmentMemberFragment, args)
    }
}