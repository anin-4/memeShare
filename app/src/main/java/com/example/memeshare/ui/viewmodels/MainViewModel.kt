package com.example.memeshare.ui.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memeshare.models.MemeEntity
import com.example.memeshare.network.GetApiData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val apiCall:GetApiData
): ViewModel() {

    private var _memes = MutableLiveData<List<MemeEntity>>()
    val memes:LiveData<List<MemeEntity>>
        get()= _memes

    init{
        getDataFromApi()
    }

    private fun getDataFromApi(){
        viewModelScope.launch {
            val response=apiCall.getAllItems()
            _memes.value=response.memes

        }
    }
}