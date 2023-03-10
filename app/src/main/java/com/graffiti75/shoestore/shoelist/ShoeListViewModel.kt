package com.graffiti75.shoestore.shoelist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.graffiti75.shoestore.Shoe

class ShoeListViewModel : ViewModel() {

    private var _shoeList = MutableLiveData<MutableList<Shoe>>()

    private var _shoeString = MutableLiveData<String>()
    val shoeString : LiveData<String>
        get() = _shoeString

    init {
        Log.i("ShoeListViewModel", "initList()")
        _shoeList.value = mutableListOf()
    }

    fun addShoeToList(shoe: Shoe) {
        _shoeList.value?.add(shoe)
        var concatString = ""
        for (shoe in _shoeList.value!!)
            concatString += "$shoe\n"
        _shoeString.value = concatString
    }
}