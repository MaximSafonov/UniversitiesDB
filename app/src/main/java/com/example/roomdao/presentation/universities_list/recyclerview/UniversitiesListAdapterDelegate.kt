package com.example.roomdao.presentation.universities_list.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdao.data.models.university.University
import com.example.roomdao.databinding.CellUniversityBinding
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import kotlinx.android.extensions.LayoutContainer
import timber.log.Timber

class UniversitiesListAdapterDelegate(
    private val onItemClicked: (item: University) -> Unit
) :
    AbsListItemAdapterDelegate<University, University, UniversitiesListAdapterDelegate.Holder>() {

    override fun isForViewType(
        item: University,
        items: MutableList<University>,
        position: Int
    ): Boolean {
        return true
    }

    override fun onCreateViewHolder(parent: ViewGroup): Holder {
        val binding: CellUniversityBinding =
            CellUniversityBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        Timber.d("onCreateViewHolder")
        return Holder(binding.root, binding)
    }

    override fun onBindViewHolder(item: University, holder: Holder, payloads: MutableList<Any>) {
        holder.bind(item, onItemClicked)
    }

    class Holder(
        override val containerView: View,
        private val binding: CellUniversityBinding,
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        init {

        }

        fun bind(item: University, onItemClicked: (item: University) -> Unit) {
            binding.universityName.text = item.name
            binding.universityCity.text = item.city
            binding.universitySpecialization.text = item.specialization
            binding.universityRank.text = item.rank

            containerView.setOnClickListener {
                onItemClicked(item)
            }
        }
    }
}