package com.grigor.kvartirka.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.grigor.kvartirka.R
import com.grigor.kvartirka.databinding.FragmentAdvertDetailsBinding
import kotlinx.android.synthetic.main.fragment_advert_details.*


class AdvertDetailsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentAdvertDetailsBinding>(
            inflater,
            R.layout.fragment_advert_details,
            container,
            false
        )
        return binding.root
    }


}