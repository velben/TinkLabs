package com.ouweibin.interview.features.main.data.net

import com.ouweibin.interview.features.main.bean.CityGuide
import retrofit2.Call

class CityGuideService private constructor(): CityGuideApi{
    companion object {
        private val INSTANT by lazy {
            CityGuideService()
        }

        @JvmStatic
        fun get() = INSTANT
    }
    private val cityGuideApi by lazy { Retrofit.get().create(CityGuideApi::class.java) }
    override fun cityGuides(): Call<List<CityGuide>> = cityGuideApi.cityGuides()

    override fun moreCityGuide(lastId: Int): Call<List<CityGuide>> =
            cityGuideApi.moreCityGuide(lastId)
}