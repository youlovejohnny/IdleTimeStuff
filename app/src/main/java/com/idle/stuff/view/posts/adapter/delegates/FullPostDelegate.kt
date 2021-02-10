package com.idle.stuff.view.posts.adapter.delegates

import adapter_delegate.AdapterDelegate
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.citrix.coroutinestest.R
import com.idle.stuff.view.posts.adapter.items.FullPostItem
import com.idle.stuff.view.posts.adapter.items.PostAdapterItem
import com.idle.stuff.view.posts.adapter.viewholders.FullPostViewHolder

class FullPostDelegate() :
    AdapterDelegate<FullPostItem, PostAdapterItem, FullPostViewHolder>(PostAdapterItem.PostAdapterItemType.FULL_POST.ordinal) {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return FullPostViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_full_post, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FullPostViewHolder, item: FullPostItem) {
        holder.nameTextView.text = item.realName
        holder.userNameTextView.text = item.userName
        holder.titleTextView.text = item.title
        holder.bodyTextView.text = item.body
    }
}