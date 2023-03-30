package com.example.sharedpreference.apiretrofit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.app.base.helper.BaseViewHolder
import com.example.sharedpreference.apiretrofit.model.FoodDetailModel
import com.example.sharedpreference.apiretrofit.model.Res_Fooddetail
import com.example.sharedpreference.databinding.FoodDataBinding

class FoodAdapter(var mData: ArrayList<Res_Fooddetail>, var mContext: Context, val name: String?) :
    RecyclerView.Adapter<FoodAdapter.Myholder>() {

    class Myholder(binding: FoodDataBinding) : BaseViewHolder<FoodDataBinding>(fBinding = binding)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myholder {
        return Myholder(FoodDataBinding.inflate(LayoutInflater.from(mContext), parent, false))
    }

    override fun onBindViewHolder(holder: Myholder, position: Int) {

        holder.fBinding.foodId.text = mData[position].foodId.toString()
        holder.fBinding.foodName.text = mData[position].foodName
        holder.fBinding.description.text = mData[position].description
        Glide.with(mContext).load(mData[position].foodImage).into(holder.fBinding.Image)

        holder.itemView.setOnClickListener() {
            Toast.makeText(mContext, name, Toast.LENGTH_SHORT).show()
        }

    }
    override fun getItemCount(): Int {
        return mData.size
    }

}