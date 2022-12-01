package com.bicontest.umc_week9

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("openapi/tour/tourinfo.do")
    fun getProducts(
        //@Query("idx") idx: Int,
    ): Call<ApiData>
}