package com.example.demo_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.demo_app.data.BusinessesModule.Businesse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class NetworkRepo() {

    // private var _list_business:MutableLiveData<List<Businesse>> = MutableLiveData();
    private val viewState=MutableLiveData<APIState<List<Businesse>>>();

    fun getBusinessByLocation(location:String,terms:String,sort_by:String,distance:Int):MutableLiveData<APIState<List<Businesse>>> {
        GlobalScope.launch{
            try {
                viewState.postValue(APIState.LOADING)
                var result=NetworkModule.getInstance().getLocation(location,terms,sort_by,distance);

                if(result.isSuccessful){
                    viewState.postValue(APIState.SUCCESS(result.body()?.businesses))
                    //_list_business.postValue(result.body()?.businesses)

                }
            }catch (e:Exception){
                e.printStackTrace()
                viewState.postValue(APIState.FAIL)
            }

        }
        return viewState
    }
    fun getListLocation():LiveData<APIState<List<Businesse>>>{
        return viewState;
    }
}