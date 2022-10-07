package com.example.demo_app

import com.example.demo_app.data.BusinessesModule.Businesse

sealed class APIState<out T> {
    object LOADING:APIState<Nothing>();
    data class SUCCESS<T>(val list: T?): APIState<T>()
    object FAIL:APIState<Nothing>()

}