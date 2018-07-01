package com.ouweibin.interview.features.main.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.ouweibin.interview.core.interactor.UseCase
import com.ouweibin.interview.core.platform.BaseViewModel
import com.ouweibin.interview.features.main.bean.CityGuide
import com.ouweibin.interview.features.main.data.repository.CityGuideRepository
import com.ouweibin.interview.features.main.interactor.GetCityGuide

class CityGuideViewModel: BaseViewModel() {
    private var latestId = 0
    val cityGuides: MutableLiveData<List<CityGuide>> = MutableLiveData()
    val moreCityGuides: MutableLiveData<List<CityGuide>> = MutableLiveData()
    private val getCityGuide = GetCityGuide(CityGuideRepository.CityGuideRepositoryImpl())

    fun loadCityGuides() {
        latestId = 0
        getCityGuide.execute({it.either(::handleFailure, ::handleCityGuides)}, GetCityGuide.Params(latestId))
    }

    fun loadMoreCityGuides() = getCityGuide.execute({it.either(::handleFailure, ::handleMoreCityGuides)}, GetCityGuide.Params(latestId))

    private fun handleCityGuides(cityGuideList: List<CityGuide>) {
        cityGuides.value = cityGuideList
        latestId += cityGuideList.size
    }

    private fun handleMoreCityGuides(cityGuideList: List<CityGuide>) {
        val list = mutableListOf<CityGuide>()
        if (moreCityGuides.value?.size!! <= 0) {
            list.addAll(cityGuides.value!!)
        } else {
            list.addAll(moreCityGuides.value!!)
        }

        list.addAll(cityGuideList)
        cityGuides.value = list
        latestId += cityGuideList.size
    }

    @Suppress("UNCHECKED_CAST")
    class CityGuideViewModelFactory: ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CityGuideViewModel::class.java)) {
                return CityGuideViewModel() as T
            }
            throw IllegalArgumentException("Unknown ViewModel class $modelClass" )
        }
    }
}