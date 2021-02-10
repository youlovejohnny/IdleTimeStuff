package com.idle.stuff.domain.interactors

import android.util.Log
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus

abstract class UseCaseWithoutResult<Params> : UseCase<Unit, Params?>() {

    fun execute(
        scope: CoroutineScope,
        params: Params?,
        onSuccess: () -> Unit,
        onError: (Throwable) -> Unit
    ) {

        if (job != null) {
            job!!.cancel()
        }

        this.scope = scope.plus(asyncJob)

        this.scope.launch {

            val deferred = doWorkAsync(params)

            try {
                deferred.await()
                onSuccess.invoke()
            } catch (throwable: CancellationException) {
                Log.d("UseCase", "The coroutine had canceled")
            } catch (throwable: Throwable) {
                onError(throwable)
            }

        }
    }
}

