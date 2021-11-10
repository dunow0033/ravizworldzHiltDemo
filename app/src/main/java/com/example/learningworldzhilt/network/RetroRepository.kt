package com.example.learningworldzhilt.network

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Query
import javax.inject.Inject

class RetroRepository @Inject constructor(private val retrofitServiceInstance: RetrofitServiceInstance) {

    fun makeApiCall(query: String, liveDatalist: MutableLiveData<List<RecyclerData>>) {
        val call: Call<RecyclerList> = retrofitServiceInstance.getDataFromAPI(query)
        call?.enqueue(object : Callback<RecyclerList>{
            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                liveDatalist.postValue(null)
            }

            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                liveDatalist.postValue(response.body()?.items!!)
            }
        })
    }
}