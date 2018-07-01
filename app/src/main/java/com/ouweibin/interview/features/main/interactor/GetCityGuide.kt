package com.ouweibin.interview.features.main.interactor

import com.ouweibin.interview.core.exception.Failure
import com.ouweibin.interview.core.functional.Either
import com.ouweibin.interview.core.interactor.UseCase
import com.ouweibin.interview.features.main.bean.CityGuide
import com.ouweibin.interview.features.main.data.repository.CityGuideRepository

class GetCityGuide(val cityGuideRepository: CityGuideRepository): UseCase<List<CityGuide>, GetCityGuide.Params>() {

    override suspend fun run(params: Params): Either<Failure, List<CityGuide>> =
        cityGuideRepository.cityGuides()

    data class Params(val id: Int)
}