package com.idle.stuff.view.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    val progressLiveData = MutableLiveData<Boolean>()
    protected val TAG = javaClass.kotlin.simpleName


    protected fun setProgress(inProgress: Boolean) {
        MainScope().launch {
            progressLiveData.value = inProgress
        }
    }

    protected fun onError(throwable: Throwable) {
        throwable.printStackTrace()
    }
}