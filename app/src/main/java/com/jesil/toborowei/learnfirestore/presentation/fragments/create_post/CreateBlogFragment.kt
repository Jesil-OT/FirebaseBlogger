package com.jesil.toborowei.learnfirestore.presentation.fragments.create_post

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jesil.toborowei.learnfirestore.R

class CreateBlogFragment : Fragment() {

    companion object {
        fun newInstance() = CreateBlogFragment()
    }

    private lateinit var viewModel: CreateBlogViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.create_blog_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CreateBlogViewModel::class.java)
        // TODO: Use the ViewModel
    }

}