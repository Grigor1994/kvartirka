package com.grigor.kvartirka.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.grigor.kvartirka.R
import com.grigor.kvartirka.data.model.remote.Currency
import com.grigor.kvartirka.data.model.remote.Flat
import com.grigor.kvartirka.databinding.AdvertRowBinding
import com.squareup.picasso.Picasso

class AdvertsAdapter(
    private val flats: List<Flat>,
    private val currency: Currency?,
    val onClick: (Flat) -> Unit
) :
    RecyclerView.Adapter<AdvertsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<AdvertRowBinding>(
            LayoutInflater.from(parent.context),
            R.layout.advert_row, parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount() = flats.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val flat = flats[position]
        Picasso.get()?.load(flat.photoDefault.url)?.into(holder.binding.photoDefault)
        holder.binding.roomsCountTextView.text = flat.rooms.toString()
        holder.binding.addressTextView.text = flat.address
        holder.binding.briefDescriptionTextView.text = flat.description
        holder.binding.currencyTextView.text = flat.prices.day.toString().plus(currency?.label)

        val bundle = Bundle()
        bundle.putParcelable("flatData", flat)

//        holder.itemView.setOnClickListener {
//            Navigation.createNavigateOnClickListener(
//                R.id.action_mainAdvertsFragment_to_advertDetailsFragment,
//                bundle
//            )
//                .onClick(holder.itemView)
//        }
    }

    inner class ViewHolder(val binding: AdvertRowBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                onClick(flats[layoutPosition])
            }
        }
    }
}