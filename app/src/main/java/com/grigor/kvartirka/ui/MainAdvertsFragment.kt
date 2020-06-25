package com.grigor.kvartirka.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.grigor.kvartirka.adapter.AdvertsAdapter
import com.grigor.kvartirka.databinding.FragmentMainAdvertsBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MainAdvertsFragment : Fragment() {

    private lateinit var binding: FragmentMainAdvertsBinding
    private val viewModel: AdvertsViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainAdvertsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getFlats(44.503490, 40.177200)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.flatsLiveData.observe(viewLifecycleOwner, Observer {
            binding.mainAdvertsRecyclerView.adapter =
                AdvertsAdapter(it?.flats?.take(it.flats.size) ?: listOf(), it?.currency)
        })
    }
}