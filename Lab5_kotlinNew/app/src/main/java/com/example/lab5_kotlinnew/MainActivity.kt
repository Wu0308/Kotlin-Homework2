package com.example.lab5_kotlinnew

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 初始化 ViewPager2
        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)

        // 初始化 Adapter，這個 Adapter 管理 Fragment 的滑動
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager2.adapter = adapter//viewPager2是一個adapter，負責管理fragment
        viewPager2.offscreenPageLimit = 1;

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = "第 ${position + 1} 頁"
        }.attach()



    }

    //override覆寫MainActivity生命週期方法
    override fun onRestart() {
        super.onRestart()
        Log.e("MainActivity", "onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.e("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("MainActivity","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MainActivity","onDestroy")
    }















}