package com.bicontest.umc_week9

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.util.Log
import com.bicontest.umc_week9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding  // viewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 바인딩 초기화
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val retrofit = RetrofitClient.retrofit
        retrofit.create(ApiService::class.java).getProducts()
            .enqueue(object : Callback<ApiData> {
                override fun onResponse(call: Call<ApiData>, response: Response<ApiData>) {
                    //Log.d(TAG, "onResponse: ${response.body().toString()}")
                    var allData: ApiData = response.body()!!
                    var tourInfoData: MutableList<TourInfoData> = allData.results
                    for(i:Int in (0..tourInfoData.size - 1)) {
                        Log.d(TAG, tourInfoData[i].toString())
                    }
                }

                override fun onFailure(call: Call<ApiData>, t: Throwable) {
                    Log.e(TAG, "onFailure: ${t.message}")
                }
            })
    }
}