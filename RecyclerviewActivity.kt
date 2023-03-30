package com.example.sharedpreference.apiretrofit.activity

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.example.app.base.helper.BaseBindingActivity
import com.example.sharedpreference.apiretrofit.adapter.RecyclerviewAdapter
import com.example.sharedpreference.apiretrofit.database.FoodDetailDatabase
import com.example.sharedpreference.apiretrofit.model.*
import com.example.sharedpreference.apiretrofit.utils.ApiClient
import com.example.sharedpreference.apiretrofit.utils.ApiInterface
import com.example.sharedpreference.databinding.ActivityRecyclerviewBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecyclerviewActivity : BaseBindingActivity<ActivityRecyclerviewBinding>() {

    var myDatalist: ArrayList<DataModel> = ArrayList()
    lateinit var mDb: FoodDetailDatabase

    override fun getActivityContext(): FragmentActivity {
        return this@RecyclerviewActivity
    }

    override fun setBinding(): ActivityRecyclerviewBinding {
        return ActivityRecyclerviewBinding.inflate(layoutInflater)
    }

    override fun initViewAction() {
        super.initViewAction()

        val apiInterface: ApiInterface = ApiClient.getClient()!!.create(ApiInterface::class.java)
        mDb = FoodDetailDatabase.getInstance(applicationContext)!!

        if (mDb.res_detailDao()!!.getAllUser()!!.isEmpty()) {

            val call: Call<MainModel> = apiInterface.getUser()
            call.enqueue(object : Callback<MainModel> {
                override fun onResponse(call: Call<MainModel>, response: Response<MainModel>) {

                    for (i in response.body()!!.dataModels!!) {

                        val resDetail = Res_detail(null, i.restaurantName!!, i.restaurantAddress!!, i.productCode!!, i.restaurantImage!!, i.restaurantId!!)

                        for (item in i.foodDetailModel!!) {
                            val resFooddetail = Res_Fooddetail(null,
                                item.foodId,
                                item.foodName!!,
                                item.description!!,
                                item.foodImage!!,
                                i.restaurantId!!)
                            mDb.res_fooddetailDao()!!.insert(resFooddetail)
                        }
                        mDb.res_detailDao()!!.insert(resDetail)
                    }

                    val data = mDb.res_detailDao()!!.getAllUser()
//                    myDatalist.addAll(response.body()!!.dataModels!!)
                    val adapter = RecyclerviewAdapter(data as ArrayList<Res_detail>, mActivity)
                    mBinding.RecyclerView.adapter = adapter
                }

                override fun onFailure(call: Call<MainModel>, t: Throwable) {
                    Toast.makeText(this@RecyclerviewActivity, "${t.message}", Toast.LENGTH_SHORT)
                        .show()
                    Log.e(TAG, "onFailure: ${t.message}")
                }
            })
        } else {
            val data = mDb.res_detailDao()!!.getAllUser()
            val adapter = RecyclerviewAdapter(data as ArrayList<Res_detail>, mActivity)
            mBinding.RecyclerView.adapter = adapter
        }
    }
}




