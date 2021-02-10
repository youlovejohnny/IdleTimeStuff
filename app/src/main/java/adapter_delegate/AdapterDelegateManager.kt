package adapter_delegate

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class AdapterDelegateManager<K> (private val delegateList: MutableList<AdapterDelegate<*, K, *>>) {

    constructor(): this(arrayListOf<AdapterDelegate<*, K, *>>())

    fun createViewHolderForViewType(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return getDelegateForItemType(viewType).onCreateViewHolder(parent)
    }

    private fun getDelegateForItemType(itemType: Int): AdapterDelegate<*, K, *> {
        val delegate =  delegateList.find { it.itemType == itemType }
        if (delegate == null) throw Throwable("Делегат не найден. Возможно, вы забыли добавить его в менеджер делегатов")
        else return delegate
    }

    fun bindViewHolderForViewType(holder: RecyclerView.ViewHolder, item: K ) {
        getDelegateForItemType(holder.itemViewType).onBindViewHolderOriginal(holder,item)
    }

    fun addDelegate(delegate: AdapterDelegate<*, K, *>) {
        delegateList.add(delegate)
    }

    fun removeAllDelegates() {
        delegateList.clear()
    }

    fun removeDelegateForViewType(viewType: Int) {
        delegateList.remove(getDelegateForItemType(viewType))
    }
}