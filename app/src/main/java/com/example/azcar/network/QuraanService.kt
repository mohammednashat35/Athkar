package com.example.azcar.network

import com.example.azcar.model.Quraan
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface QuraanApi{

    @GET("quran-uthmani")
    suspend fun getPropirty():Response<Quraan>
}


object RetrofitInstance {

    val api: QuraanApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://api.alquran.cloud/v1/quran/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuraanApi::class.java)
    }

}