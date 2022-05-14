package com.example.roomdao.presentation.universities_list

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.roomdao.R
import com.example.roomdao.data.models.university.University
import com.example.roomdao.databinding.FragmentUniversitiesBinding
import com.example.roomdao.presentation.BaseFragment
import com.example.roomdao.presentation.universities_list.recyclerview.UniversitiesListAdapter
import com.example.roomdao.presentation.viewmodels.UniversitiesListViewModel
import com.example.roomdao.utils.autoCleared
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class UniversitiesListFragment : BaseFragment<FragmentUniversitiesBinding>() {

    private val viewModel by viewModels<UniversitiesListViewModel>()
    private var adapterUniversities by autoCleared<UniversitiesListAdapter>()

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addButton.setOnClickListener {
            findNavController().navigate(R.id.action_universitiesListFragment_to_fragmentUniversityAdd)
        }
        initList()

        bindViewModel()

        binding.appBar.toolbar.apply {
            title = "Перечень университетов"
            textAlignment = View.TEXT_ALIGNMENT_CENTER
            setTitleTextColor(R.color.black)
        }
    }

    private fun initList() {
        adapterUniversities = UniversitiesListAdapter { university -> onItemClick(university) }

        with(binding.universityList) {
            adapter = adapterUniversities
            setHasFixedSize(true)
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    private fun bindViewModel() {
        viewModel.loadList()

        viewModel.users.onEach {
            adapterUniversities.items = it
        }.launchIn(CoroutineScope(Dispatchers.IO))

    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentUniversitiesBinding {
        return FragmentUniversitiesBinding.inflate(inflater, container, false)
    }

    private fun onItemClick(university: University) {
        viewModel.deleteUniversity(university)
    }
}