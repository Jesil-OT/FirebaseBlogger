package com.jesil.toborowei.learnfirestore.presentation.fragments.blog_post

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.jesil.toborowei.learnfirestore.R
import com.jesil.toborowei.learnfirestore.databinding.PostFragmentBinding

class PostFragment : Fragment() {

    private var _binding: PostFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PostFragmentBinding.inflate(layoutInflater, container, false)
        binding.createPostFab.setOnClickListener {
            it.findNavController().navigate(R.id.createBlogFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}