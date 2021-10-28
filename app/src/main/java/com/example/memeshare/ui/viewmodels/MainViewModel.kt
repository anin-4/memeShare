package com.example.memeshare.ui.viewmodels


import android.util.Log
import androidx.lifecycle.*
import com.example.memeshare.models.MemeEntity
import com.example.memeshare.network.GetApiData
import com.example.memeshare.respository.MainRepository
import com.example.memeshare.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
): ViewModel() {


    private var _memes = MutableLiveData<Resource<List<MemeEntity>>>()
    val memes:LiveData<Resource<List<MemeEntity>>>
        get() {
            return _memes
        }

    init{
        getDataFromApi()
    }

   fun getDataFromApi(){
       viewModelScope.launch {
           repository.getAllData().collect {
               Log.d("viewModel", "getDataFromApi: ${it.data?.size}")
               _memes.value=it

           }
       }
    }
}