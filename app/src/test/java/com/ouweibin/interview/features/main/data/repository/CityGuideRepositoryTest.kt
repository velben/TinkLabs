package com.ouweibin.interview.features.main.data.repository

import android.content.Context
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.verify
import com.ouweibin.interview.UnitTest
import com.ouweibin.interview.core.functional.Either
import com.ouweibin.interview.core.platform.NetworkHandler
import com.ouweibin.interview.features.main.bean.CityGuide
import com.ouweibin.interview.features.main.data.net.CityGuideService
import org.amshove.kluent.shouldEqual
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import retrofit2.Call
import retrofit2.Response

class CityGuideRepositoryTest :UnitTest(){
    private lateinit var cityGuideRepository: CityGuideRepository

    @Mock private lateinit var context: Context
    private lateinit var service: CityGuideService
    @Mock private lateinit var cityGuidesCall: Call<List<CityGuide>>
    @Mock private lateinit var cityGuidesResponse: Response<List<CityGuide>>

    @Before fun setUp() {
        cityGuideRepository = CityGuideRepository.CityGuideRepositoryImpl()
        service = CityGuideService.get()
    }

    @Test
    fun cityGuides() {
        given { NetworkHandler.isConnected(context) }.willReturn(true)
        given { cityGuidesResponse.body() }.willReturn(null)
        given { cityGuidesResponse.isSuccessful }.willReturn(true)
        given { cityGuidesCall.execute() }.willReturn(cityGuidesResponse)
        given { service.cityGuides() }.willReturn(cityGuidesCall)

        val cityGuides = cityGuideRepository.cityGuides()

        cityGuides shouldEqual Either.Right(emptyList<CityGuide>())
        verify(service).cityGuides()
    }

    @Test
    fun moreCityGuides() {
    }
}