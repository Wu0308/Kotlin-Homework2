package com.example.lab5_kotlinnew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FragmentOne : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 填充 Layout 佈局，返回 View 對象
        return inflater.inflate(R.layout.fragment_one, container, false)
    }




}