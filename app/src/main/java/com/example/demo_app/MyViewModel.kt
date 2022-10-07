package com.example.demo_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demo_app.data.BusinessesModule.Businesse

class MyViewModel():ViewModel() {
    private val networkRepo = NetworkRepo();

    fun apiToGetBusinessByLocation(location:String,terms:String,sort_by:String,distance:Int):MutableLiveData<APIState<List<Businesse>>>{
        return networkRepo.getBusinessByLocation(location,terms,sort_by,distance);
    }
    fun getListBusinessByLocation():LiveData<APIState<List<Businesse>>>{
        return networkRepo.getListLocation()
    }

}