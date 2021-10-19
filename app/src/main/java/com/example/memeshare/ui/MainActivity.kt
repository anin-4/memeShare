package com.example.memeshare.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.memeshare.databinding.ActivityMainBinding
import com.example.memeshare.ui.adapters.MemeViewPagerAdapter
import com.example.memeshare.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    private val memeVIewPagerAdapter:MemeViewPagerAdapter = MemeViewPagerAdapter()
    private val viewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.memeViewPager.adapter=memeVIewPagerAdapter


        viewModel.memes.observe(this,{
            val data = it
            data?.let{ list->
                memeVIewPagerAdapter.memes=list
            }

        })

    }
}