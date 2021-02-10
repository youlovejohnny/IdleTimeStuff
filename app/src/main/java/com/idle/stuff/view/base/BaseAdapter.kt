package com.idle.stuff.view.base

import adapter_delegate.AdapterDelegateManager
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*

abstract class BaseAdapter<ADAPTER_ITEM : BaseAdapterItem> :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    protected val delegateManager = object : AdapterDelegateManager<ADAPTER_ITEM>() {}
    private val items = ArrayList<ADAPTER_ITEM>()
    abstract val diffCallback: BaseDiffCallback<ADAPTER_ITEM>?

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        addDelegates()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateManager.createViewHolderForViewType(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateManager.bindViewHolderForViewType(holder, items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].getViewType()
    }

    abstract fun addDelegates()

    fun update(newItems: List<ADAPTER_ITEM>) {
        GlobalScope.launch(Dispatchers.Default) {
            diffCallback?.setOldItems(items)
            diffCallback?.setNewItems(newItems)
            val result = DiffUtil.calculateDiff(diffCallback!!)
            withContext(Dispatchers.Main) {
                items.clear()
                items.addAll(newItems)
                result.dispatchUpdatesTo(this@BaseAdapter)
            }
        }
    }
}