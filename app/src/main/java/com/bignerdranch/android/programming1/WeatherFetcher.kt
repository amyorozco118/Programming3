package com.bignerdranch.android.programming1

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val TAG = "WeatherFetchr"
class WeatherFetcher {

    private val weatherApi: WeatherApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
        weatherApi = retrofit.create(WeatherApi::class.java)
    }


    fun fetchContents(): LiveData<String> {
        val responseLiveData: MutableLiveData<String> = MutableLiveData()
        val weatherRequest: Call<String> = weatherApi.fetchContents()
        weatherRequest.enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e(TAG, "Failed to fetch weather", t)
            }
            override fun onResponse(
                call: Call<String>,
                response: Response<String>
            ){
                Log.d(TAG, "Response received")
                responseLiveData.value = response.body()
            }
        })
        return responseLiveData
    }
}