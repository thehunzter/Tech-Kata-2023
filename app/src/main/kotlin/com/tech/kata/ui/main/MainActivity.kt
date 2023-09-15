package com.tech.kata.ui.main

import android.os.Bundle
import com.tech.kata.R
import com.tech.kata.TechKataApplication
import com.tech.kata.databinding.ActivityMainBinding
import com.tech.kata.ui.BaseActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>(), MainContract.View {

    override fun getToolbarTitle(): Int = R.string.app_name

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.setView(this)
        presenter.onViewCreated()
    }

    override fun showText(text: String) {
        binding.mainScreenText.text = text
    }
}
