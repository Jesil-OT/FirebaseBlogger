package com.jesil.toborowei.learnfirestore.presentation.fragments.home

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.jesil.toborowei.learnfirestore.R
import com.jesil.toborowei.learnfirestore.databinding.HomeFragmentBinding
import com.jesil.toborowei.learnfirestore.presentation.fragments.utils.adapter.HomeViewPagerAdapter


class HomeFragment : Fragment() {
    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = HomeFragmentBinding.inflate(layoutInflater, container, false)
        val viewPagerAdapter = HomeViewPagerAdapter(requireActivity())
        binding.viewPagerHome.adapter = viewPagerAdapter
        TabLayoutMediator(binding.tabLayoutHome, binding.viewPagerHome) { tab, position ->
            when (position) {
                0 -> tab.apply {
                    text = "Posts"
                    badge?.number = 1
                }
                1 -> tab.text = "Profile"
            }
        }.attach()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}