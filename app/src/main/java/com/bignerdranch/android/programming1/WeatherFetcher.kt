package com.bignerdranch.android.programming1

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "WeatherFetchr"
class WeatherFetcher {

    private val weatherApi: WeatherApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        weatherApi = retrofit.create(WeatherApi::class.java)
    }


    fun fetchContents(): MutableLiveData<MainResponse> {
        val responseLiveData: MutableLiveData<MainResponse> = MutableLiveData()
        val weatherRequest: Call<MainResponse> = weatherApi.fetchContents()

        weatherRequest.enqueue(object : Callback<MainResponse> {

            override fun onFailure(call: Call<MainResponse>, t: Throwable) {
                Log.e(TAG, "Failed to fetch weather", t)
            }

            override fun onResponse(
                call: Call<MainResponse>,
                response: Response<MainResponse>
            ){
                Log.d(TAG, "Response received")
                val mainResponse: MainResponse? = response.body()
                responseLiveData.value = mainResponse
            }
        })
        return responseLiveData
    }
}