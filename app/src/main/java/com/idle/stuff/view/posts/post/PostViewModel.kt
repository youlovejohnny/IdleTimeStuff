package com.idle.stuff.view.posts.post

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.idle.stuff.domain.interactors.posts.GetFullPostUseCase
import com.idle.stuff.view.base.BaseViewModel
import com.idle.stuff.view.posts.adapter.items.*

class PostViewModel @ViewModelInject constructor(
    private val getFullPostUseCase: GetFullPostUseCase
) : BaseViewModel() {
    val fullPostLiveData = MutableLiveData<List<PostAdapterItem>>()

    fun getFullPost(postId: Int) {
        setProgress(true)
        getFullPostUseCase.execute(viewModelScope, GetFullPostUseCase.Params(postId), {
            val newValue  =  ArrayList<PostAdapterItem>().apply {
                add(FullPostItem(it.postId, it.user.name, it.user.userName, it.title, it.body))
                add(CommentsHeaderItem())
                for (comment in it.comments) {
                    add(CommentItem(comment.id, comment.body))
                }
            }
            fullPostLiveData.value = newValue

            setProgress(false)
        }, {
            setProgress(false)
            onError(it)
        })
    }


}