package com.example.sharedpreference.apiretrofit.activity

import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.base.helper.BaseBindingActivity
import com.example.sharedpreference.apiretrofit.adapter.FoodAdapter
import com.example.sharedpreference.apiretrofit.model.FoodDetailModel
import com.example.sharedpreference.apiretrofit.model.Res_Fooddetail
import com.example.sharedpreference.databinding.ActivityFoodDetailBinding


class FoodDetailActivity : BaseBindingActivity<ActivityFoodDetailBinding>() {

    var mData: ArrayList<Res_Fooddetail> = ArrayList()

    override fun getActivityContext(): FragmentActivity {
        return this@FoodDetailActivity
    }

    override fun setBinding(): ActivityFoodDetailBinding {
       return ActivityFoodDetailBinding.inflate(layoutInflater)
    }

    override fun initViewAction() {
        super.initViewAction()

        val intent = intent
        val args = intent.getBundleExtra("BUNDLE")
        mData= args!!.getSerializable("key") as ArrayList<Res_Fooddetail>

        val name = intent.getStringExtra("name")
//        Toast.makeText(mActivity, " $name", Toast.LENGTH_SHORT).show()

        mBinding.foodRecyclerview.layoutManager=LinearLayoutManager(this)
        var adapter=FoodAdapter(mData,mActivity,name)
        mBinding.foodRecyclerview.adapter=adapter
    }
}
