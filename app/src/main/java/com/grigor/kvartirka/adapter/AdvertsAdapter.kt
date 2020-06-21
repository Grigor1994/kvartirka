package com.grigor.kvartirka.adapter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.grigor.kvartirka.R
import com.grigor.kvartirka.data.Advert
import com.squareup.picasso.Picasso

class AdvertsAdapter(private val adverts: ArrayList<Advert>) :
    RecyclerView.Adapter<AdvertsAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val advert = adverts[position]
        Picasso.get().load(adverts[position].photoDefault).into(holder.image)
        holder.address.text = advert.address
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.advert_row, parent, false)
        val holder = ViewHolder(view)
        view.setOnClickListener {
            val address = adverts[holder.bindingAdapterPosition].address
            val bundle = Bundle()
            bundle.putString("address", address)
            Navigation.createNavigateOnClickListener(
                R.id.action_mainAdvertsFragment_to_advertDetailsFragment,
                bundle).onClick(view)
            Log.d("Adapter", address)
        }
        return holder
    }

    override fun getItemCount() = adverts.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.photoDefault)
        val address: TextView = itemView.findViewById(R.id.addressTextView)
    }
}