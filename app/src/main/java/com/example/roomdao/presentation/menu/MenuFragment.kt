package com.example.roomdao.presentation.menu

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.roomdao.R
import com.example.roomdao.databinding.FragmentMenuBinding
import com.example.roomdao.presentation.BaseFragment

class MenuFragment: BaseFragment<FragmentMenuBinding>() {

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.universitiesButton.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_universitiesListFragment)
        }
        binding.departmentsButton.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_departmentsListFragment)
        }
        binding.appBar.toolbar.apply {
            title = "Меню"
            textAlignment = View.TEXT_ALIGNMENT_CENTER
            setTitleTextColor(R.color.black)
        }
    }

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentMenuBinding {
        return FragmentMenuBinding.inflate(inflater, container, false)
    }
}