package com.grigor.kvartirka.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.grigor.kvartirka.databinding.FragmentMainAdvertsBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MainAdvertsFragment : Fragment() {

    private lateinit var binding: FragmentMainAdvertsBinding

    private val viewModel: MainAdvertsViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainAdvertsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getFlats(44.503490,40.177200)
    }
}