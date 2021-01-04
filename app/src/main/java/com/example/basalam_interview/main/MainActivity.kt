package com.example.basalam_interview.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basalam_interview.R
import com.example.basalam_interview.repositories.ProductsRepository
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var productsRepository: ProductsRepository

    private lateinit var productsListAdapter: ProductsListAdapter

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
        initialize()
        showProducts()
    }

    private fun initialize() {
        viewModel = ViewModelProvider(this, MainViewModelFactory(productsRepository)).get(
            MainViewModel::class.java
        )
    }

    private fun showProducts() {
        viewModel.getProducts().observe(this, Observer {
            val mLayoutManager: RecyclerView.LayoutManager =
                GridLayoutManager(this, 2)
            rc_test.layoutManager = mLayoutManager
            productsListAdapter = ProductsListAdapter(it)
            rc_test.adapter = productsListAdapter
        })

        viewModel.liveDataError.observe(this, Observer {
            Toast.makeText(this, "مشکل در دریافت اطلاعات !!!", Toast.LENGTH_LONG).show()
        })
    }
}