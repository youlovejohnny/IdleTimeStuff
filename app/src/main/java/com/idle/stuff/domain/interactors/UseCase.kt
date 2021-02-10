package com.idle.stuff.domain.interactors

import kotlinx.coroutines.*

abstract class UseCase<T, Params : Any?> {
    var job: Job? = null
    val asyncJob = SupervisorJob()

    protected val io = Dispatchers.IO
    protected val main = Dispatchers.Main
    protected val default = Dispatchers.Default
    lateinit var scope: CoroutineScope

    fun cancel(cause: CancellationException? = null) {
        job?.cancel(cause)
        job = null
    }

    protected abstract suspend fun executeOnBackground(params: Params?): T

    protected suspend fun doWorkAsync(params: Params?): Deferred<T> {
        return scope.async(default) {
            executeOnBackground(params)
        }.also { job = it }
    }
}