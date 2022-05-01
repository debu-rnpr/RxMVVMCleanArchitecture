package com.mvrx.data.api

import com.mvrx.data.dto.CatBreedDTO
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    @GET(ENDPOINT_BREEDS)
    fun getBreeds(): Single<List<CatBreedDTO>>
}