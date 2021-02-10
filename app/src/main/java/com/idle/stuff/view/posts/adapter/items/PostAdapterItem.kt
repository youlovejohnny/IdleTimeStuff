package com.idle.stuff.view.posts.adapter.items

import com.idle.stuff.view.base.BaseAdapterItem

abstract class PostAdapterItem(val type: PostAdapterItemType) : BaseAdapterItem() {

    override fun getViewType(): Int {
        return type.ordinal
    }

    enum class PostAdapterItemType {
        FEED_POST,
        COMMENTS_HEADER,
        COMMENT,
        FULL_POST
    }
}