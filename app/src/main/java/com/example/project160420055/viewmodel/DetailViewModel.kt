package com.example.project160420055.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.project160420055.model.Hobby
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DetailViewModel(application: Application): AndroidViewModel(application)  {
    private val TAG = "volleyTag"
    private var queue: RequestQueue? = null
    val detailLD = MutableLiveData<Hobby>()

    fun refresh(id: Int) {
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://my-json-server.typicode.com/Renky32/hobiUbaya/hobby?id=$id"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val hobbyListType = object : TypeToken<List<Hobby>>() {}.type
                val hobbies: List<Hobby> = Gson().fromJson(response, hobbyListType)

                if (hobbies.isNotEmpty()) {
                    val selectedHobby = hobbies[0]
                    detailLD.value = selectedHobby
                } else {
                    Log.d(TAG, "No hobby found with ID: $id")
                }
            },
            { error ->
                Log.d(TAG, "Error fetching hobby: ${error.message}")
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }

}