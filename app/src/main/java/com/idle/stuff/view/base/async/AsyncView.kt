package com.idle.stuff.view.base.async

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.FrameLayout
import androidx.asynclayoutinflater.view.AsyncLayoutInflater

open class AsyncView(context: Context) : FrameLayout(context, null, 0) {

    init {
        layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT)
    }

    open val layoutId = -1
    private var isInflated = false
    private var bindingFunctions: (AsyncView?.() -> Unit)? = null
    lateinit var view: View

    fun inflate() {
        AsyncLayoutInflater(context).inflate(layoutId, this) { view, resId, parent ->
            this.view = view
            isInflated = true
            addView(bindViews(view))
            bindView()
        }
    }

    private fun bindView() {
        bindingFunctions?.invoke(this)
    }

    fun bindWhenInflated(bindFunc: AsyncView?.() -> Unit) {
        if (isInflated) {
            bindFunc()
        } else {
            bindingFunctions = bindFunc
        }
    }

    open fun bindViews(view: View): View? = view
}