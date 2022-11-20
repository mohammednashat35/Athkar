package com.example.azcar.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.azcar.model.Surah
import com.example.azcar.network.RetrofitInstance
import kotlinx.coroutines.launch


enum class QuraanApiStatus { LOADING, ERROR, DONE }

class MainViewModel() : ViewModel() {

    private val _properties = MutableLiveData<List<Surah>>()
    val properties: LiveData<List<Surah>>
        get() = _properties


    private val _status = MutableLiveData<QuraanApiStatus>()
    val status: LiveData<QuraanApiStatus>
        get() = _status

    init {

        getProperties()
    }





    private fun getProperties(){

        viewModelScope.launch {

            _status.value = QuraanApiStatus.LOADING

            try {
              _properties.value = RetrofitInstance.api.getPropirty().body()?.let { it.data.surahs }
                _status.value = QuraanApiStatus.DONE
            }catch (e:Exception){
                _status.value = QuraanApiStatus.ERROR
               _properties.value = ArrayList()
            }

        }
    }


}