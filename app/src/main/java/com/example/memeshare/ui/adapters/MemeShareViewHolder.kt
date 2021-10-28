package com.example.memeshare.ui.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.memeshare.databinding.MemeItemListBinding
import com.example.memeshare.models.MemeEntity

sealed class MemeShareViewHolder(binding: ViewBinding):RecyclerView.ViewHolder(binding.root) {

        var itemListener: ((item: MemeEntity, view: View) -> Unit)? = null


    class MemeViewHolder(private val binding: MemeItemListBinding):MemeShareViewHolder(binding){

        fun bind(meme:MemeEntity){
            binding.textView.text=meme.title
            Glide.with(itemView).load(meme.ImgUrl).into(binding.memeImageViewInside)

            binding.shareActionButton.setOnClickListener {
                    itemListener?.invoke(meme,binding.shareActionButton)

            }
        }
    }

}