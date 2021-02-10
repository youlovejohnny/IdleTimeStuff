package com.idle.stuff.domain.interactors.posts

import com.idle.stuff.data.repository.Repository
import com.idle.stuff.domain.interactors.UseCaseWithResult
import com.idle.stuff.domain.models.CommentModel
import com.idle.stuff.domain.models.FullPostModel
import com.idle.stuff.domain.models.PostModel
import com.idle.stuff.domain.models.UserModel
import kotlinx.coroutines.async
import javax.inject.Inject

class GetFullPostUseCase @Inject constructor(private val repository: Repository) :
    UseCaseWithResult<FullPostModel, GetFullPostUseCase.Params>() {

    data class Params(val postId: Int)

    private fun map(
        postModel: PostModel,
        comments: List<CommentModel>,
        userModel: UserModel
    ): FullPostModel {
        return FullPostModel(
            postId = postModel.id,
            user = userModel,
            title = postModel.title,
            body = postModel.body,
            comments = comments
        )
    }

    override suspend fun executeOnBackground( params: Params?): FullPostModel {
            val postModel = scope.async(io) {
                repository.getPost(postId = params!!.postId)
            }.await()

            val comments = scope.async(io) {
                repository.getComments(postId = params!!.postId)
            }

            val userModel = scope.async(io) {
                repository.getUser(userId = postModel.userId)
            }

        return map(postModel, comments.await(), userModel.await())


    }
}