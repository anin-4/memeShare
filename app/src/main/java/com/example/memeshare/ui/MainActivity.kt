package com.example.memeshare.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.example.memeshare.databinding.ActivityMainBinding
import com.example.memeshare.models.MemeEntity
import com.example.memeshare.ui.adapters.MemeViewPagerAdapter
import com.example.memeshare.ui.transitionanimations.DepthAnimationViewPager
import com.example.memeshare.ui.viewmodels.MainViewModel
import com.example.memeshare.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val memeVIewPagerAdapter:MemeViewPagerAdapter = MemeViewPagerAdapter()
    private val viewModel:MainViewModel by viewModels()
    private var currentMemeCountMultiplier:Int=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.memeViewPager.adapter=memeVIewPagerAdapter
        memeVIewPagerAdapter.itemListener ={item: MemeEntity,_ ->
            val intent = Intent().apply {
                action=Intent.ACTION_SEND
                type="text/plain"
                putExtra(Intent.EXTRA_TEXT,item.ImgUrl)

            }
            val shareIntent =Intent.createChooser(intent,"Share this meme")
            startActivity(shareIntent)

        }
        binding.memeViewPager.setPageTransformer(DepthAnimationViewPager())



        binding.memeViewPager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    if((position+1)==currentMemeCountMultiplier*10){
                        Log.d("mainActivity", "onPageSelected: called!!")
                        viewModel.getDataFromApi()
                        currentMemeCountMultiplier+=1
                    }
                }


            }
        )

        viewModel.memes.observe(this,{
            val data = it.data
            data?.let{ list->
                memeVIewPagerAdapter.memes.addAll(list)
                memeVIewPagerAdapter.notifyItemInserted(data.size-1)
            }
            binding.progressCircular.isVisible =  it is Resource.Loading && it.data.isNullOrEmpty()
            binding.noInternetImage.isVisible = it is Resource.Error && it.data.isNullOrEmpty()

        })

    }

}