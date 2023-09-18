package com.tech.kata.ui.main

import android.os.Bundle
import com.tech.kata.R
import com.tech.kata.databinding.ActivityMainBinding
import com.tech.kata.common.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun getToolbarTitle(): Int = R.string.app_name

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.setView(this)

        binding.searchButton.setOnClickListener {
            presenter.getPeople()
        }
    }

    override fun showName(name: String) {
        binding.mainScreenText.text = name
    }

    override fun showErrorMessage(message: String) {
        binding.mainScreenText.text = message
    }

}
