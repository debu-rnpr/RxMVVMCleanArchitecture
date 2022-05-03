package com.mvrx.domain.usecases.base

import io.reactivex.disposables.CompositeDisposable

abstract class UseCase<in P, R> {
    protected val compositeDisposable = CompositeDisposable()

    /**
     * Executes the current use case.
     */
    abstract fun execute(
        param: P,
        onStart: () -> Unit = {},
        onSuccess: (r: R) -> Unit,
        onFailure: (t: Throwable) -> Unit,
        onFinished: () -> Unit = {}
    )

    fun dispose() {
        compositeDisposable.clear()
    }
}