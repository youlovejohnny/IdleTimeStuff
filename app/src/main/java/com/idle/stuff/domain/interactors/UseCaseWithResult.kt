package com.idle.stuff.domain.interactors

import android.util.Log
import kotlinx.coroutines.*

abstract class UseCaseWithResult<T, Params> : UseCase<T, Params?>() {

    fun execute(
        scope: CoroutineScope,
        params: Params?,
        onSuccess: (T) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        if (job != null) {
            cancel()
        }

        this.scope = scope.plus(asyncJob)
        this.scope.launch {
            val deferred = doWorkAsync(params)
            try {
                onSuccess.invoke(deferred.await())
            } catch (throwable: CancellationException) {
                Log.d("UseCase", "The coroutine had canceled")
            } catch (throwable: Throwable) {
                onError(throwable)
            }

        }
    }


}