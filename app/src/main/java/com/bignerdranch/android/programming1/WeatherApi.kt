package com.bignerdranch.android.programming1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface WeatherApi {

    //api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}
    //api.openweathermap.org/data/2.5/weather?q=Worcester,us&appid=205d86bed14ecd2289e59656c4b76a91
    @GET
        //("http://api.openweathermap.org/" + "data/2.5/weather?q=" + "Worcester,us" + "&appid=" + "205d86bed14ecd2289e59656c4b76a91")

    fun fetchContents(@Url url : String): Call<MainResponse>

}