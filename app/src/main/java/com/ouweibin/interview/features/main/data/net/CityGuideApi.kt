package com.ouweibin.interview.features.main.data.net

import com.ouweibin.interview.features.main.bean.CityGuide
import retrofit2.Call
import retrofit2.http.GET

internal interface CityGuideApi{
    companion object {
        private const val CITY_GUIDES = "CITY_GUIDES"
        private const val MORE_CITY_GUIDES = "MORE_CITY_GUIDES"
    }

    @GET(CITY_GUIDES) fun cityGuides(): Call<List<CityGuide>>
    @GET(MORE_CITY_GUIDES) fun moreCityGuide(lastId: Int):Call<List<CityGuide>>
}