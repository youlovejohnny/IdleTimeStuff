package com.idle.stuff.view.posts.post

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.citrix.coroutinestest.R
import com.idle.stuff.view.posts.adapter.PostAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_post.*
import kotlinx.android.synthetic.main.fragment_posts.recyclerView

@AndroidEntryPoint
class PostFragment : Fragment(R.layout.fragment_post) {
    private val viewModel: PostViewModel by viewModels()
    private val navArgs by navArgs<PostFragmentArgs>()

    private val adapter by lazy { PostAdapter({}) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getFullPost(navArgs.postId)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        viewModel.fullPostLiveData.observe(viewLifecycleOwner, adapter::update)
        viewModel.progressLiveData.observe(viewLifecycleOwner, this::onProgress)
    }

    private fun initRecyclerView() {
        recyclerView.adapter = adapter
    }

    private fun onProgress(inProgress: Boolean) {
        progressBar.isVisible = inProgress
    }
}