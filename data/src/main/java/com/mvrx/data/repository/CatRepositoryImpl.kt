package com.mvrx.data.repository

import com.mvrx.data.api.ApiService
import com.mvrx.data.extension.toCatBreed
import com.mvrx.domain.model.CatBreed
import com.mvrx.domain.repository.CatRepository
import io.reactivex.Single

class CatRepositoryImpl(private val apiService: ApiService) : CatRepository {
    override fun getCatBreeds(): Single<List<CatBreed>> {
        return apiService.getBreeds().map { it.toCatBreed() }
    }
}