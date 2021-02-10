package com.idle.stuff.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.*
import androidx.core.content.ContextCompat

object ResExtractor {
    private lateinit var context: Context

    fun init(context: Context) {
        this.context = context
    }

    fun getColor(@ColorRes colorId: Int): Int = ContextCompat.getColor(context, colorId)


    fun getDrawable(@DrawableRes drawableId: Int): Drawable =
        ContextCompat.getDrawable(context, drawableId)!!

    fun getString(@StringRes stringResId: Int): String = context.getString(stringResId)

    fun getString(@StringRes stringResId: Int, vararg args: Any): String =
        context.getString(stringResId, *args)

    fun getInteger(@IntegerRes integerRes: Int): Int = context.resources.getInteger(integerRes)

    fun <T> runWithContext(block: (context: Context) -> T?): T? = block(context)

    fun getDimen(@DimenRes resId: Int) = context.resources.getDimension(resId)

    fun getColorStateList(@ColorRes colorId: Int) = ContextCompat.getColorStateList(context, colorId)
}