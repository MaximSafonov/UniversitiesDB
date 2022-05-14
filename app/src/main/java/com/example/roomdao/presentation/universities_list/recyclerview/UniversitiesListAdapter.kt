package com.example.roomdao.presentation.universities_list.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.example.roomdao.data.models.university.University
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import timber.log.Timber

class UniversitiesListAdapter(onItemClicked: (item: University) -> Unit): AsyncListDifferDelegationAdapter<University>(UniversityCallback()) {

    init {
        delegatesManager.addDelegate(UniversitiesListAdapterDelegate(onItemClicked))
        Timber.d("delegatedManager")
    }

    class UniversityCallback: DiffUtil.ItemCallback<University>() {
        override fun areItemsTheSame(oldItem: University, newItem: University): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: University, newItem: University): Boolean {
            return oldItem.id == newItem.id
        }
    }
}