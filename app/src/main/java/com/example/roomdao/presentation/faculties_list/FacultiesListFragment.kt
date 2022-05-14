package com.example.roomdao.presentation.faculties_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.roomdao.databinding.FragmentFacultiesListBinding
import com.example.roomdao.presentation.BaseFragment
import com.example.roomdao.presentation.viewmodels.FacultiesViewModel

class FacultiesListFragment: BaseFragment<FragmentFacultiesListBinding>() {

    private val viewModel: FacultiesViewModel by viewModels()

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFacultiesListBinding {
        return FragmentFacultiesListBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TODO init viewModel

    }

    fun initList() {
        //TODO create recycler

    }
}