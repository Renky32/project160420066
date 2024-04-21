package com.example.project160420055.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.project160420055.model.Hobby
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListViewModel(application: Application): AndroidViewModel(application) {
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null
    val newsLD = MutableLiveData<ArrayList<Hobby>>()
    val newsLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD =MutableLiveData<Boolean>()

    fun refresh(){
        queue = Volley.newRequestQueue( getApplication()  )
        val url = "https://my-json-server.typicode.com/Renky32/hobiUbaya/hobby"
        val stringRequest=StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<Hobby>>() { }.type
                val result = Gson().fromJson<List<Hobby>>(it, sType)
                newsLD.value = result as ArrayList<Hobby>?
                loadingLD.value = false

                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
                newsLoadErrorLD.value = false
                loadingLD.value = false
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }

}