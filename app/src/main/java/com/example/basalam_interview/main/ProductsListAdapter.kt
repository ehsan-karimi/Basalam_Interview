package com.example.basalam_interview.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.basalam_interview.model.entities.Products
import com.example.basalam_interview.R
import kotlinx.android.synthetic.main.item_products_list.view.*

class ProductsListAdapter(employeeModel: List<Products>) :
    RecyclerView.Adapter<ProductsListAdapter.EmployeeViewHolder>() {
    private val employeeModel: List<Products>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        return EmployeeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_products_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.bind(employeeModel[position])
    }

    override fun getItemCount(): Int {
        return employeeModel.size
    }

    inner class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n")
        fun bind(employeeModel: Products) {
            itemView.tv_title_productsList.setText(employeeModel.name)
            itemView.tv_description_productsList.setText(employeeModel.vendor)
            itemView.tv_weight_productsList.setText(employeeModel.weight.toString() + " " + "گرم")
            itemView.tv_rateCount_productsList.setText("(" + employeeModel.ratingCount.toString() + ")" + " " + employeeModel.rating.toString())
            val a = String.format("%,d", employeeModel.price.toLong())
            itemView.tv_price.setText(a + " " + "تومان")
            Glide.with(itemView).load(employeeModel.photo).into(itemView.iv_productsList);
        }
    }

    init {
        this.employeeModel = employeeModel
    }
}

