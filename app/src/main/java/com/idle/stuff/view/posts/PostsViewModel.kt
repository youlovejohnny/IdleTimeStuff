package com.idle.stuff.view.posts

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import com.idle.stuff.domain.interactors.posts.SubscribeForPostsUseCase
import com.idle.stuff.domain.interactors.posts.UpdatePostsUseCase
import com.idle.stuff.view.base.BaseViewModel
import com.idle.stuff.view.posts.adapter.items.PostAdapterItem

class PostsViewModel @ViewModelInject constructor(
    private val updatePostsUseCase: UpdatePostsUseCase,
    private val subscribeForPostsUseCase: SubscribeForPostsUseCase
) : BaseViewModel() {

    val postsLiveData = MediatorLiveData<List<PostAdapterItem>>()

    init {
        updatePosts()
        subscribeForPosts()
    }

    private fun updatePosts() {
        updatePostsUseCase.execute(viewModelScope, null,
            {
                Log.d(TAG, "updatePosts: success")
        }, {
                onError(it)
        })
    }

    private fun subscribeForPosts() {
        subscribeForPostsUseCase.execute(viewModelScope, null, {
            postsLiveData.addSource(it) {
                postsLiveData.value = it
            }
        },{
            onError(it)
        })
    }

}