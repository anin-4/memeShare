package com.example.memeshare.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.memeshare.databinding.MemeItemListBinding
import com.example.memeshare.models.MemeEntity

class MemeViewPagerAdapter:RecyclerView.Adapter<MemeShareViewHolder>() {

    var memes:MutableList<MemeEntity> = mutableListOf()

    var itemListener:((item:MemeEntity,view: View)->Unit)?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeShareViewHolder {
        val binding = MemeItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MemeShareViewHolder.MemeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MemeShareViewHolder, position: Int) {
        holder.itemListener=itemListener
        when(holder){
            is MemeShareViewHolder.MemeViewHolder -> holder.bind(memes[position])
        }
    }

    override fun getItemCount(): Int {
        return memes.size
    }


}