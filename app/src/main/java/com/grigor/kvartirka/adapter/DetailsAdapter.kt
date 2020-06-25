package com.grigor.kvartirka.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.grigor.kvartirka.R
import com.grigor.kvartirka.data.model.remote.Photo
import com.grigor.kvartirka.databinding.DetailsRowBinding
import com.squareup.picasso.Picasso

class DetailsAdapter(
    private val photos: List<Photo>
) :
    RecyclerView.Adapter<DetailsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<DetailsRowBinding>(
            LayoutInflater.from(parent.context),
            R.layout.details_row, parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = photos[position]
        Picasso.get()?.load(photo.url)?.fit()?.into(holder.binding.imageView)
    }

    class ViewHolder(val binding: DetailsRowBinding) : RecyclerView.ViewHolder(binding.root) {
    }
}

