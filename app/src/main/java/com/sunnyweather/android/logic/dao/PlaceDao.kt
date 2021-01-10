package com.sunnyweather.android.logic.dao

import android.content.Context
import android.provider.Settings.Global.putString
import androidx.core.content.edit
import com.google.gson.Gson
import com.sunnyweather.android.SunnyWeatherApplication
import com.sunnyweather.android.logic.model.Place

object PlaceDao {
    fun savePlace(place: Place){
        sharedPrefernces().edit {
            putString("place",Gson().toJson(place))
        }
    }
    fun getSavePlace():Place{
        val placeJson= sharedPrefernces().getString("place","")
        return Gson().fromJson(placeJson,Place::class.java)
    }
    fun isPlaceSaved()= sharedPrefernces().contains("place")
    private fun sharedPrefernces()=SunnyWeatherApplication.context.getSharedPreferences("sunny_weather",Context.MODE_PRIVATE)
}
