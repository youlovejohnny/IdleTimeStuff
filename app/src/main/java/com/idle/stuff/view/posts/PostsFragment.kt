package com.idle.stuff.view.posts

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.idle.stuff.R
import com.idle.stuff.view.PostsDecorator
import com.idle.stuff.view.posts.adapter.PostAdapter
import com.idle.stuff.view.posts.async_adapter.PostsAsyncAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_posts.*

@AndroidEntryPoint
class PostsFragment: Fragment(R.layout.fragment_posts) {

    private val viewModel: PostsViewModel by viewModels()
    private val adapter by lazy { PostsAsyncAdapter(this::onPostClick) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        viewModel.postsLiveData.observe(viewLifecycleOwner, adapter::update)
    }

    private fun initRecyclerView() {
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(PostsDecorator())
    }

    private fun onPostClick(postId: Int) {
        findNavController().navigate(PostsFragmentDirections.actionPostsFragmentToPostFragment(postId))
    }

}