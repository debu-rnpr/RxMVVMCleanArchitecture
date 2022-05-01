package com.mvrx.domain.repository

import com.mvrx.domain.model.CatBreed
import io.reactivex.Single

interface CatRepository {
    fun getCatBreeds(): Single<List<CatBreed>>
}