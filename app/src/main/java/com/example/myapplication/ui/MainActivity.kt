package com.example.myapplication.ui


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.ahmadhamwi.tabsync.TabbedListMediator
import com.example.myapplication.R
import com.example.myapplication.model.VendorDetails
import com.example.myapplication.network.RetrofitClientInstance.retrofitInstance
import com.example.myapplication.network.RetrofitService
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var recyclerView: RecyclerView

    private val categories = ArrayList<VendorDetails.Data.VendorsItem>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        loadVendorData()

        initRecycler()


    }

    private fun initViews() {
        tabLayout = findViewById(R.id.tabLayout)
        recyclerView = findViewById(R.id.recyclerView)
    }

    private fun initTabLayout() {
        for (category in categories) {
            tabLayout.addTab(tabLayout.newTab().setText(category.vendorCategoryName))
        }
    }

    private fun initRecycler() {
        recyclerView.adapter = CategoriesAdapter(this, categories)

    }

    private fun initMediator() {
        TabbedListMediator(
            recyclerView,
            tabLayout,
            categories.indices.toList()
        ).attach()
    }

    private  fun loadVendorData(){
        val service: RetrofitService = retrofitInstance!!.create(
            RetrofitService::class.java
        )
        val call: Call<VendorDetails> = service.getVendorDetails()
        call!!.enqueue( object : Callback<VendorDetails>{
            override fun onResponse(call: Call<VendorDetails>, response: Response<VendorDetails>) {
                 for (i in 0 until response.body()!!.data.vendorsItems.size){
                      categories.add(
                          VendorDetails.Data.VendorsItem(
                              response.body()!!.data.vendorsItems[i].items,
                              response.body()!!.data.vendorsItems[i].vendorCategoryId,
                              response.body()!!.data.vendorsItems[i].vendorCategoryName,

                          ))
                 }
                runOnUiThread {
                    initTabLayout()
                    initMediator()
                    recyclerView.adapter!!.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<VendorDetails>, t: Throwable) {
                Log.e("apiError",t.message!!)
            }

        })
    }
}