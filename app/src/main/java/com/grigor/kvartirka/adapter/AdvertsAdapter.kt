package com.grigor.kvartirka.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.grigor.kvartirka.R
import com.grigor.kvartirka.data.model.remote.Flat

class AdvertsAdapter(private val flats: List<Flat>) :
    RecyclerView.Adapter<AdvertsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val binding = DataBindingUtil.inflate<AdvertRowBinding>(
//            LayoutInflater.from(parent.context),
//            R.layout.advert_row, parent, false
//        )
        val view = LayoutInflater.from(parent.context).inflate(R.layout.advert_row, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = flats.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val flat = flats[position]
//        Picasso.get().load(flat[position].photoDefault).into(holder.image)
//        holder.address.text = advert.address
//        holder.binding.addressTextView.text = flat?.address

//        holder.binding.flat = flats.get(position)
//        holder.address.text = flat.address
//        Log.i("Adapter", flat.address)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val address: TextView = itemView.findViewById(R.id.addressTextView)
    }
}