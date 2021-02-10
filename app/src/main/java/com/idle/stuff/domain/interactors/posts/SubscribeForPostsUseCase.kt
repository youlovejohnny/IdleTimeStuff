package com.idle.stuff.domain.interactors.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.idle.stuff.data.repository.Repository
import com.idle.stuff.domain.interactors.UseCaseWithResult
import com.idle.stuff.domain.models.PostModel
import com.idle.stuff.view.posts.adapter.items.PostAdapterItem
import javax.inject.Inject

class SubscribeForPostsUseCase @Inject constructor(
    private val repository: Repository
) : UseCaseWithResult<LiveData<List<PostAdapterItem>>, Any?>() {

    override suspend fun executeOnBackground(
        params: Any?
    ): LiveData<List<PostAdapterItem>> {
        val postsLiveData = repository.getPostsLiveData()
        return Transformations.map(postsLiveData) {
            PostModel.mapToFeedPostItems(it)
        }
    }


}