package com.example.lab5_kotlinnew

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle)
    : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        // 返回 ViewPager2 中頁面的數量
        return 3 // 有 3 個頁面
    }

    override fun createFragment(position: Int): Fragment {
        // 根據 position 返回對應的 Fragment
        return when (position) {
            0 -> FragmentOne() // 第一個頁面
            1 -> FragmentTwo() // 第二個頁面
            else -> FragmentThree() // 第三個頁面
        }
    }
}