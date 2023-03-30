package com.example.sharedpreference.apiretrofit.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.app.ads.helper.NativeAdsSize
import com.example.app.ads.helper.NativeAdvancedModelHelper
import com.example.sharedpreference.R
import com.example.sharedpreference.apiretrofit.activity.FoodDetailActivity
import com.example.sharedpreference.apiretrofit.database.FoodDetailDatabase
import com.example.sharedpreference.apiretrofit.model.Res_detail
import com.google.android.gms.ads.nativead.NativeAd
import java.io.Serializable


class RecyclerviewAdapter(var dataModels: ArrayList<Res_detail>, var mContext: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var mDb: FoodDetailDatabase
    val LAYOUT_ONE = 0
    val LAYOUT_TWO = 3

    override fun getItemViewType(position: Int): Int {
        return if (position == 2)
            LAYOUT_ONE
        else
            LAYOUT_TWO
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == LAYOUT_TWO) {
            DataHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerviewdata, parent, false))
        } else
            AdHolder(LayoutInflater.from(parent.context).inflate(R.layout.native_ad, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is DataHolder) {
            holder.restaurant_name.text = dataModels[position].restaurantName
            holder.restaurant_address.text = dataModels[position].restaurantAddress
            holder.product_code.text = dataModels[position].productCode
            Glide.with(mContext).load(dataModels[position].restaurantImage).into(holder.Image)

            holder.itemView.setOnClickListener() {
//            MyfoodData.addAll(myData[position].foodDetail!!)
                val name: String = dataModels[position].restaurantName!!

                mDb = FoodDetailDatabase.getInstance(mContext)!!

                var abc = dataModels[position].restaurantId
                Log.e("TAG", "onBindViewHolder: $abc")
                val food = mDb.res_fooddetailDao()!!.getAll(abc)
                Log.e("TAG", "onBindViewHolder: ${food!!.size}")
                var intent = Intent(mContext, FoodDetailActivity::class.java)
                val args = Bundle()
                args.putSerializable("key", food as Serializable)
                intent.putExtra("BUNDLE", args)
                intent.putExtra("name", name)
                mContext.startActivity(intent)
            }
        } else if (holder is AdHolder) {
            NativeAdvancedModelHelper(mContext as Activity).loadNativeAdvancedAd(
                NativeAdsSize.Medium,
                holder.frameLayout)
        }

    }

    override fun getItemCount(): Int {
        return dataModels.size
    }

    class DataHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var restaurant_name: TextView = itemView.findViewById(R.id.restaurant_name)
        var restaurant_address: TextView = itemView.findViewById(R.id.restaurant_address)
        var product_code: TextView = itemView.findViewById(R.id.product_code)
        var Image: ImageView = itemView.findViewById(R.id.Image)
    }

    class AdHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var frameLayout: FrameLayout = itemView.findViewById(R.id.Nativ_Ad)

    }

}


