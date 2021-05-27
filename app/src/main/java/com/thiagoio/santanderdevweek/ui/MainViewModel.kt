package com.thiagoio.santanderdevweek.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thiagoio.santanderdevweek.data.Conta
import com.thiagoio.santanderdevweek.local.FakeData

class MainViewModel : ViewModel() {


    private val _mutableLiveData: MutableLiveData<Conta> = MutableLiveData()


    fun buscarContaCliente() : LiveData<Conta>{
        _mutableLiveData.value = FakeData().getLocalData()

        return _mutableLiveData
    }

}