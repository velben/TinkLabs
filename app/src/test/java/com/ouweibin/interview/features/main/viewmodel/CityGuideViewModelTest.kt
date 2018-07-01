package com.ouweibin.interview.features.main.viewmodel

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.given
import com.ouweibin.interview.AndroidTest
import com.ouweibin.interview.core.extension.empty
import com.ouweibin.interview.core.functional.Either
import com.ouweibin.interview.features.main.bean.CityGuide
import com.ouweibin.interview.features.main.interactor.GetCityGuide
import kotlinx.coroutines.experimental.runBlocking
import org.amshove.kluent.shouldEqualTo
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class CityGuideViewModelTest : AndroidTest(){
    private lateinit var cityGuideViewModel: CityGuideViewModel
    @Mock private lateinit var getCityGuide: GetCityGuide

    @Before fun setUp() {
        cityGuideViewModel = CityGuideViewModel()
    }

    @Test
    fun loadCityGuides() {
        val cityGuides = arrayListOf(CityGuide("http://www.baidu.com", "title1", "description1"),
                CityGuide("http://www.hao123.com", String.empty(), String.empty()))
        given { runBlocking { getCityGuide.run(eq(any())) } }.willReturn(Either.Right(cityGuides))

        cityGuideViewModel.cityGuides.observeForever {
            it!!.size shouldEqualTo 2
            it[0].imgUrl shouldEqualTo "http://www.baidu.com"
            it[0].title shouldEqualTo "title1"
            it[0].description shouldEqualTo "description1"
            it[1].imgUrl shouldEqualTo "http://www.hao123.com"
            it[1].title shouldEqualTo String.empty()
            it[1].description shouldEqualTo String.empty()
        }

        runBlocking { cityGuideViewModel.loadCityGuides() }
    }

    @Test
    fun loadMoreCityGuides() {
    }
}