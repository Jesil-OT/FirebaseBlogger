package com.jesil.toborowei.learnfirestore.presentation.fragments.utils.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jesil.toborowei.learnfirestore.presentation.fragments.blog_post.PostFragment
import com.jesil.toborowei.learnfirestore.presentation.fragments.profile.ProfileFragment

class HomeViewPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> PostFragment()
            1 -> ProfileFragment()
            else -> PostFragment()
        }
    }

    override fun getItemCount(): Int = 2
}