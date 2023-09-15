package com.tech.kata.ui.main

import android.os.Bundle
import com.tech.kata.R
import com.tech.kata.databinding.ActivityMainBinding
import com.tech.kata.ui.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getToolbarTitle(): Int = R.string.app_name

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}
