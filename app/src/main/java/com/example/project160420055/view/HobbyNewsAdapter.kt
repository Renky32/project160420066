package com.example.project160420055.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project160420055.databinding.HobbyListItemBinding
import com.example.project160420055.model.Hobby
import com.squareup.picasso.Picasso

class HobbyNewsAdapter(val hobbyList : ArrayList<Hobby>):
    RecyclerView.Adapter<HobbyNewsAdapter.HobbyViewHolder>() {
    val newHobbyList = ArrayList<Hobby>()

    class HobbyViewHolder(var binding: HobbyListItemBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HobbyViewHolder {
        val binding = HobbyListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return HobbyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return hobbyList.size
    }

    override fun onBindViewHolder(holder: HobbyViewHolder, position: Int) {
        holder.binding.txtJudul.text = hobbyList[position].judul
        holder.binding.txtNama.text = hobbyList[position].username
        holder.binding.txtSinopsis.text = hobbyList[position].sinopsis
        Picasso.get().load(hobbyList[position].urlGambar).into(holder.binding.imgNews)

    }
    fun updateNewsList(newHobbyList: ArrayList<Hobby>){
        hobbyList.clear()
        hobbyList.addAll(newHobbyList)
        notifyDataSetChanged()
    }


}