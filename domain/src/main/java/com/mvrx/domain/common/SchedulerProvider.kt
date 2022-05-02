package com.mvrx.domain.common

import io.reactivex.Scheduler

/**
 * interface defining diff Scheduler to be used in async communications
 */
interface SchedulerProvider {
    fun io(): Scheduler
    fun ui(): Scheduler
}