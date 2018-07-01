package com.ouweibin.interview.features.main.interactor

import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import com.ouweibin.interview.UnitTest
import com.ouweibin.interview.core.functional.Either
import com.ouweibin.interview.features.main.bean.CityGuide
import com.ouweibin.interview.features.main.data.repository.CityGuideRepository
import kotlinx.coroutines.experimental.runBlocking
import org.amshove.kluent.mock
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`

//class GetCityGuideTest : UnitTest() {
//    private lateinit var getCityGuides : GetCityGuide
//
//    @Mock lateinit var cityGuideRepository :CityGuideRepository
//
//    @Before
//    fun setUp() {
//        getCityGuides = GetCityGuide(cityGuideRepository)
//        given { cityGuideRepository.cityGuides() }.willReturn(Either.Right(listOf(CityGuide.empty())))
//    }
//
//    @Test
//    fun `should get data from repository`() {
//        runBlocking { getCityGuides.run { GetCityGuide.Params(-1) } }
//
//        verify(cityGuideRepository).cityGuides()
//        verifyNoMoreInteractions(cityGuideRepository)
//    }
//}