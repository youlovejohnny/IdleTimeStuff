package adapter_delegate

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * @param itemType  view type
 * @property T - тип элемента адаптера
 * @property K - общий тип элементов адаптера
 * @property V - тип ViewHolder
 * */

abstract class AdapterDelegate<T : K, K, V : RecyclerView.ViewHolder>(val itemType: Int) :
    AdapterDelegateInterface<T, K, V> {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return onCreateViewHolder(parent)
    }

}

