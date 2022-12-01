package com.bicontest.umc_week9

import com.google.gson.annotations.SerializedName

//"record_count":126,"address":"","name":"","pageunit":10,"page":1,"results
data class ApiData(
    @SerializedName("record_count")
    val record_count: Int,

    @SerializedName("address")
    val address: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("pageunit")
    val pageunit: Int,

    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val results: MutableList<TourInfoData>,
)

// 경상남도 진주시_관광정보 데이터
data class TourInfoData(
    //@SerializedName("idx")
    //val idx: Int,                   // index

    @SerializedName("name")
    val name: String,               // 관광지명

    @SerializedName("category")
    val category: String,           // 카테고리

    @SerializedName("area")
    val area: String,               // 읍면동

    @SerializedName("manage")
    val manage: String,             // 주관? ex. CGV

    @SerializedName("phone")
    val phone: String,              // 전화번호

    @SerializedName("hompage")
    val hompage: String,            // 홈페이지 url

    @SerializedName("content")
    val content: String,            // 설명

    @SerializedName("fee")
    val fee: String,                // 이용료

    @SerializedName("usehour")
    val usehour: String,            // 이용시간

    @SerializedName("address")
    val address: String,            // 주소

    @SerializedName("xposition")
    val xposition: String,          // x 좌표...?

    @SerializedName("yposition")
    val yposition: String,          // y 좌표...?

    @SerializedName("parking")
    val parking: String,            // 주차

    @SerializedName("image")
    val image: MutableList<String>, // 이미지 리스트
)
