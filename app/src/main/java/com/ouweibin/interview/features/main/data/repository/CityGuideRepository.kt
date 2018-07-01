package com.ouweibin.interview.features.main.data.repository

import com.ouweibin.interview.core.functional.Either
import com.ouweibin.interview.core.functional.Either.Left
import com.ouweibin.interview.core.functional.Either.Right
import com.ouweibin.interview.core.exception.Failure
import com.ouweibin.interview.core.platform.NetworkHandler
import com.ouweibin.interview.features.AndroidApplication
import com.ouweibin.interview.features.main.bean.CityGuide
import com.ouweibin.interview.features.main.data.net.CityGuideService
import retrofit2.Call

interface CityGuideRepository{
    fun cityGuides(): Either<Failure, List<CityGuide>>
    fun moreCityGuides(): Either<Failure, List<CityGuide>>
    class CityGuideRepositoryImpl: CityGuideRepository {
        override fun cityGuides(): Either<Failure, List<CityGuide>> {
            return when(NetworkHandler.isConnected(AndroidApplication.get())){
                true -> request(CityGuideService.get().cityGuides(), {it.map { it }}, emptyList())
                false, null -> Either.Left(Failure.NetworkConnection())
            }
        }

        override fun moreCityGuides(): Either<Failure, List<CityGuide>> {
            return when (NetworkHandler.isConnected(AndroidApplication.get())) {
                true -> request(CityGuideService.get().moreCityGuide(-1), {it.map { it }}, emptyList())
                    false, null -> Left(Failure.NetworkConnection())
            }
        }

        private fun<T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure, R> {
            return try {
                val response = call.execute()
                when(response.isSuccessful) {
                    true -> Right(transform(response.body() ?: default))
                    false -> Left(Failure.ServerError())
                }
            } catch (exception: Throwable) {
                Left(Failure.ServerError())
            }
        }

    }
}