package com.mvrx.data.extension

import com.mvrx.data.dto.CatBreedDTO
import com.mvrx.domain.model.CatBreed

fun List<CatBreedDTO>.toCatBreed(): List<CatBreed> {
    val breedList = mutableListOf<CatBreed>()
    this.forEach {
        breedList.add(
            CatBreed(
                id = it.id,
                name = it.name,
                imageUrl = it.image.url,
                weight = it.weight.metric,
                origin = it.origin
            )
        )
    }
    return breedList
}