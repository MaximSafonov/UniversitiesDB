package com.example.roomdao.presentation.university_add

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.roomdao.R
import com.example.roomdao.data.models.university.University
import com.example.roomdao.databinding.FramgentUniversityAddBinding
import com.example.roomdao.presentation.BaseFragment
import com.example.roomdao.presentation.viewmodels.UniversitiesListViewModel

class FragmentUniversityAdd : BaseFragment<FramgentUniversityAddBinding>() {

    private val viewModel by viewModels<UniversitiesListViewModel>()

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addUniversityButton.setOnClickListener {
            viewModel.addUniversity(
                University(
                    id = 0,
                    name = binding.editUniversityName.text.toString(),
                    city = binding.editUniversityCity.text.toString(),
                    specialization = binding.editUniversitySpecialization.text.toString(),
                    rank = binding.editUniversityRank.text.toString()
                )
            )
            Toast.makeText(
                requireContext(),
                "${binding.editUniversityName.text.toString()} добавлен",
                Toast.LENGTH_LONG
            ).show()
        }
        binding.appBar.toolbar.apply {
            title = "Добавить университет"
            textAlignment = View.TEXT_ALIGNMENT_CENTER
            setTitleTextColor(R.color.black)
        }
    }


    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FramgentUniversityAddBinding {
        return FramgentUniversityAddBinding.inflate(inflater, container, false)
    }
}