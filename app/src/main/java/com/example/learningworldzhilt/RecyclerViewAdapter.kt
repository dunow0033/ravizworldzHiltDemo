package com.example.learningworldzhilt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.learningworldzhilt.databinding.RecyclerRowBinding
import com.example.learningworldzhilt.databinding.RecyclerRowBinding.inflate
import com.example.learningworldzhilt.network.RecyclerData

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var listData: List<RecyclerData>? = null

    fun setlistData(listData: List<RecyclerData>?) {
        this.listData = listData
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.MyViewHolder {
        //val view  = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)

        return MyViewHolder(RecyclerRowBinding.inflate(
          LayoutInflater.from(parent.context),
          parent,
          false
        ))
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if(listData == null)
            return 0
        return listData?.size!!
    }

    class MyViewHolder(val binding: RecyclerRowBinding): RecyclerView.ViewHolder(binding.root) {

//        val thumbImage = .thumbImage
//        val tvName = view.tvName
//        val tvDesc = view.tvDesc

        fun bind(data: RecyclerData) {
            with(binding) {
                tvName.text = data.name
                tvDesc.text = data.description

                Glide.with(thumbImage)
                    .load(data.owner?.avatar_url)
                    .into(thumbImage)
            }
        }
    }
}