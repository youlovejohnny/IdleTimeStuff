package com.idle.stuff.view.base

import androidx.recyclerview.widget.DiffUtil

abstract class BaseDiffCallback<T>(private val oldItems: ArrayList<T> = arrayListOf(), private val newItems: ArrayList<T> = arrayListOf()) : DiffUtil.Callback() {

    protected fun getNewItem(position: Int): T {
        return newItems[position]
    }

    protected fun getOldItem(position: Int): T {
        return oldItems[position]
    }

    override fun getNewListSize(): Int {
        return newItems.size
    }

    override fun getOldListSize(): Int {
        return oldItems.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = getOldItem(oldItemPosition)
        val newItem = getNewItem(newItemPosition)
        return areContentsTheSame(oldItem, newItem)
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = getOldItem(oldItemPosition)
        val newItem = getNewItem(newItemPosition)
        return areItemsTheSame(oldItem, newItem)
    }

    abstract fun areItemsTheSame(oldItem: T, newItem: T): Boolean

    abstract fun areContentsTheSame(oldItem: T, newItem: T): Boolean

    fun setOldItems(oldItems: List<T>) {
        this.oldItems.clear()
        this.oldItems.addAll(oldItems)
    }

    fun setNewItems(newItems: List<T>) {
        this.newItems.clear()
        this.newItems.addAll(newItems)
    }
}