package com.example.project160420055.viewmodel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.project160420055.R
import com.example.project160420055.model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONException

class LoginViewModel(application: Application): AndroidViewModel(application) {
    val userLD = MutableLiveData<ArrayList<User>>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun login(username: String, password: String) {
        queue = Volley.newRequestQueue( getApplication()  )
        val url = "https://my-json-server.typicode.com/Renky32/hobiUbaya/" +
                "users?username=$username&password=$password"

        val stringRequest = StringRequest(
            Request.Method.GET,url,{
                val sType = object : TypeToken<List<User>>() { }.type
                val result = Gson().fromJson<List<User>>(it, sType)
                userLD.value = result as ArrayList<User>?

                Log.d("showvoley", result.toString())
            },{
                Log.d("showvoley", it.toString())

            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)

    }
    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}