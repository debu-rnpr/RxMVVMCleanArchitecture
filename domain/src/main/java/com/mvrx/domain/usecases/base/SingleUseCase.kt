package com.mvrx.domain.usecases.base

import com.mvrx.domain.common.SchedulerProvider
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

abstract class SingleUseCase<in P, R>(private val scheduler: SchedulerProvider) : UseCase<P, R>() {

    /**
     * Builds which will be used when executing the current [UseCase].
     */
    protected abstract fun build(param: P): Single<R>

    override fun execute(
        param: P,
        onStart: () -> Unit,
        onSuccess: (r: R) -> Unit,
        onFailure: (t: Throwable) -> Unit,
        onFinished: () -> Unit
    ) {
        // dispose running calls
        dispose()
        val disposable = build(param)
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .doOnSubscribe{onStart.invoke()}
            .doAfterTerminate(onFinished)
            .subscribe(onSuccess, onFailure)

        compositeDisposable.add(disposable)
    }
}