package com.bignerdranch.android.programming1

import retrofit2.Call
import retrofit2.http.GET

interface WeatherApi {





    @GET(
    "data/2.5/weather?q=London"+ "&appid=205d86bed14ecd2289e59656c4b76a91"
    )

    fun fetchContents(): Call<String>
}