package com.example.restaurantapplication.api

import com.example.restaurantapplication.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @Headers(
        "X-Partner-API-Key: uonebancservceemultrS3cg8RaL30",
        "Content-Type: application/json"
    )
    @POST("/emulator/interview/get_item_list")
    fun getItemList(@Body request: ItemListRequest): Call<ItemListResponse>

    @POST("/emulator/interview/get_item_by_id")
    fun getItemById(@Body request: ItemIdRequest): Call<ItemResponse>

    @POST("/emulator/interview/get_item_by_filter")
    fun getItemByFilter(@Body request: FilterRequest): Call<ItemListResponse>

    @POST("/emulator/interview/make_payment")
    fun makePayment(@Body request: PaymentRequest): Call<PaymentResponse>

    @GET("/emulator/interview/get_item_list")
    fun getFoodItems(): Call<ItemListResponse>


}
