package com.example.memeshare.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.memeshare.databinding.MemeItemListBinding
import com.example.memeshare.models.MemeEntity

class MemeViewPagerAdapter:RecyclerView.Adapter<MemeShareViewHolder>() {

    var memes:List<MemeEntity> = listOf()
        set(value) {
        field = value
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeShareViewHolder {
        val binding = MemeItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MemeShareViewHolder.MemeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MemeShareViewHolder, position: Int) {
        when(holder){
            is MemeShareViewHolder.MemeViewHolder -> holder.bind(memes[position])
        }
    }

    override fun getItemCount(): Int {
        return memes.size
    }


}