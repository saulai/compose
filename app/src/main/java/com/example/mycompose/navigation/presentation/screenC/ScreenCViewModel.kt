package com.example.mycompose.navigation.presentation.screenC

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class ScreenCViewModel : ViewModel() {

    private val _input = MutableLiveData<String>()
    var input: LiveData<String> = _input

    private val _showDialog = MutableLiveData<Boolean>()
    var showDialog: LiveData<Boolean> = _showDialog

    fun onInputChanged(input: String) {
        _input.value = input
        if (input.length > 4) {
            viewModelScope.launch {
                //llamada a backend
                //mostrar input
                _showDialog.value = true
            }
        }
    }

    fun dismissDialog() {
        _showDialog.value = false
    }
}