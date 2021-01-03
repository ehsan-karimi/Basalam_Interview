package com.example.basalam_interview.Main

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basalam_interview.Model.Entities.Products
import com.example.basalam_interview.R
import com.google.android.material.card.MaterialCardView
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
                private val vendor: TextView? = null

        @SuppressLint("SetTextI18n")
        fun bind(employeeModel: Products) {
//            fullNameTv.setText(employeeModel.getFirstname() + " " + employeeModel.getLastname());
                itemView.tv_title_productsList.setText(employeeModel.name)
        }

        init {
            //            fullNameTv = itemView.findViewById(R.id.tv_student_fullName);


        }
    }

    init {
        this.employeeModel = employeeModel
    }
}

