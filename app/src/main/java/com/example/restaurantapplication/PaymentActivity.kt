package com.example.restaurantapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurantapplication.R
import com.example.restaurantapplication.api.ApiService
import com.example.restaurantapplication.model.PaymentRequest
import com.example.restaurantapplication.model.PaymentItem
import com.example.restaurantapplication.model.PaymentResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PaymentActivity : AppCompatActivity() {
    private lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        apiService = com.example.restaurantapplication.network.ApiClient.getClient().create(
            ApiService::class.java)
        makePayment()
    }

    private fun makePayment() {
        val request = PaymentRequest(400, 5)
        request.addItem(PaymentItem(32453, 15234, 200, 1, orderId = 1001))
        request.addItem(PaymentItem(32453, 15234, 50, 4, orderId = 1002))

        apiService.makePayment(request).enqueue(object : Callback<PaymentResponse> {
            override fun onResponse(call: Call<PaymentResponse>, response: Response<PaymentResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    Log.d("PAYMENT", "Transaction ID: ${response.body()?.txnRefNo}")
                } else {
                    Log.e("PAYMENT_ERROR", "Response failed: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<PaymentResponse>, t: Throwable) {
                Log.e("PAYMENT_ERROR", "Payment Failed: ${t.message}")
            }
        })
    }
}
