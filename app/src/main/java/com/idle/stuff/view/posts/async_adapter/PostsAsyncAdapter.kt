package com.idle.stuff.view.posts.async_adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.idle.stuff.R
import com.idle.stuff.view.base.async.AsyncView
import com.idle.stuff.view.posts.adapter.PostAdapterDiffCallback
import com.idle.stuff.view.posts.adapter.items.FeedPostItem
import com.idle.stuff.view.posts.adapter.items.PostAdapterItem
import kotlinx.android.synthetic.main.item_feed_post.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostsAsyncAdapter(private val onPostClick: (Int) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = ArrayList<PostAdapterItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FeedPostAsyncViewHolder(FeedPostAsyncView(parent.context).apply { inflate() })
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder.itemView as FeedPostAsyncView).bindWhenInflated {
            items[position].let { item ->
                item as FeedPostItem
                this as FeedPostAsyncView
                titleTextView.text = item.title
                bodyTextView.text = item.body
                rootConstraintLayout.setOnClickListener { onPostClick(item.postId) }
                postId = item.postId

            }
        }
    }

    private inner class FeedPostAsyncViewHolder(view: ViewGroup) :
        RecyclerView.ViewHolder(view)


    override fun getItemViewType(position: Int): Int {
        return items[position].getViewType()
    }

    class FeedPostAsyncView(context: Context) : AsyncView(context) {
        override val layoutId = R.layout.item_feed_post

        lateinit var titleTextView: TextView
        lateinit var bodyTextView: TextView
        lateinit var rootConstraintLayout: ConstraintLayout

        var postId = 0

        override fun bindViews(view: View): View {
            titleTextView = view.titleTextView as TextView
            bodyTextView = view.bodyTextView as TextView
            rootConstraintLayout = view.rootConstraintLayout as ConstraintLayout
            return view
        }
    }

    fun update(newItems: List<PostAdapterItem>) {
        val diffCallback = PostAdapterDiffCallback()
        GlobalScope.launch(Dispatchers.Default) {
            diffCallback.setOldItems(items)
            diffCallback.setNewItems(newItems)
            val result = DiffUtil.calculateDiff(diffCallback)
            withContext(Dispatchers.Main) {
                items.clear()
                items.addAll(newItems)
                result.dispatchUpdatesTo(this@PostsAsyncAdapter)
            }
        }
    }

}