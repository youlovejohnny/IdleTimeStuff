package com.idle.stuff.domain.interactors.posts

import com.idle.stuff.data.repository.Repository
import com.idle.stuff.domain.interactors.UseCaseWithoutResult
import javax.inject.Inject

class UpdatePostsUseCase @Inject constructor(private val repository: Repository): UseCaseWithoutResult< Any?>() {


    override suspend fun executeOnBackground(params: Any?) {
        val posts = repository.getPosts()
        repository.savePosts(posts)
    }


}