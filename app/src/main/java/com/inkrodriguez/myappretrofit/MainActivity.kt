package com.inkrodriguez.myappretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.inkrodriguez.myappretrofit.api.Slip
import com.inkrodriguez.myappretrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.adviceslip.com/"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            getMyData()
        }

    }

    private fun getMyData() {

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

            retrofitData.enqueue(object : Callback<Slip> {
                override fun onResponse(call: Call<Slip>, response: Response<Slip>) {
                    val responseBody = response.body()!!

                           binding.tvAdvice.text = responseBody.slip.advice

                }

                override fun onFailure(call: Call<Slip>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }

}