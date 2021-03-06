package com.grigor.kvartirka.ui

import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.grigor.kvartirka.R
import com.grigor.kvartirka.adapter.DetailsAdapter
import com.grigor.kvartirka.databinding.FragmentAdvertDetailsBinding
import kotlinx.android.synthetic.main.details_row.*
import kotlinx.android.synthetic.main.fragment_advert_details.*

class AdvertDetailsFragment : Fragment() {

    private lateinit var binding: FragmentAdvertDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentAdvertDetailsBinding>(
            inflater,
            R.layout.fragment_advert_details,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: AdvertDetailsFragmentArgs? =
            arguments?.let { AdvertDetailsFragmentArgs.fromBundle(it) }
        val flat = args?.flatData
        descriptionFull.text =
            HtmlCompat.fromHtml(flat?.descriptionFull.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
        Log.d("Detail", flat?.descriptionFull)
        val gridLayoutManager = GridLayoutManager(requireContext(), 4)

        detailsAdvertsRecyclerView.apply {
            layoutManager = gridLayoutManager
            if (flat != null) adapter = DetailsAdapter(flat.photos)
            setHasFixedSize(true)
        }
    }
}