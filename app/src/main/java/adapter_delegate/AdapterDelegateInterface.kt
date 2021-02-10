@file:Suppress("UNCHECKED_CAST")

package adapter_delegate

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * * @property T - тип элемента адаптера
 * @property K - общий тип элементов адаптера
 * @property V - тип ViewHolder
 * */
interface AdapterDelegateInterface<T,K,V> {
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolderOriginal(holder: RecyclerView.ViewHolder, item: K) {
        val newItem  = item as T
        onBindViewHolder(holder as V, newItem)
    }

    fun onBindViewHolder(holder: V, item: T)

}