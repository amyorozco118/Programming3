package com.bignerdranch.android.programming1

import com.google.gson.annotations.SerializedName


/* A typical json response:
    {
        "coord":{
                "lon":-0.1257,"lat":51.5085
            },
        "weather":[{
                "id":802,"main":"Clouds",
                "description":"scattered clouds",
                "icon":"03n"
         }],
        "base":"stations",
  TODO  "main":{
  TODO          "temp":284.48,

                "feels_like":283.68,
                "temp_min":283.22,
                "temp_max":285.52,
                "pressure":1009,
                "humidity":77
         },
        "visibility":10000,
        "wind":{
                "speed":7.07,
                "deg":273,
                "gust":14.03
         },
        "clouds":{
                "all":49
         },
        "dt":1633466936,
        "sys":{
                "type":2,
                "id":2019646,
                "country":"GB",
                "sunrise":1633414061,
                "sunset":1633454992
         },
         "timezone":3600,
         "id":2643743,
  TODO   "name":"London",

         "cod":200
         }

 */

class MainResponse {

    @SerializedName("main")
    lateinit var main: MainObject

    @SerializedName("name")
    lateinit var name : String

}