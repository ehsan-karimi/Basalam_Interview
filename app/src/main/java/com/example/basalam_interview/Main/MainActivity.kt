package com.example.basalam_interview.Main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basalam_interview.R
import com.example.basalam_interview.Repositories.ProductsRepository
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var productsRepository: ProductsRepository

    lateinit var productsListAdapter:ProductsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this, MainViewModelFactory(productsRepository)).get(
            MainViewModel::class.java
        )
        viewModel.getProducts().observe(this, Observer {
            val mLayoutManager: RecyclerView.LayoutManager =
                GridLayoutManager(this, 2)
            rc_test.setLayoutManager(mLayoutManager)
            //    recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext(), RecyclerView.VERTICAL, false));
            //    recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext(), RecyclerView.VERTICAL, false));
            productsListAdapter = ProductsListAdapter(it)
            rc_test.setAdapter(productsListAdapter)
        })


    }
}