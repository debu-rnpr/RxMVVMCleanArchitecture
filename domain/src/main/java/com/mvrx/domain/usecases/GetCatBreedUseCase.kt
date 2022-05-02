package com.mvrx.domain.usecases

import com.mvrx.domain.common.SchedulerProvider
import com.mvrx.domain.model.CatBreed
import com.mvrx.domain.repository.CatRepository
import com.mvrx.domain.usecases.base.SingleUseCase
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

class GetCatBreedUseCase @Inject constructor(
    private val repository: CatRepository, scheduler: SchedulerProvider
) : SingleUseCase<Unit, List<CatBreed>>(scheduler = scheduler) {

    override fun build(param: Unit): Single<List<CatBreed>> {
        return repository.getCatBreeds()
    }
}