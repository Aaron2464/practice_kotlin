package com.example.assignment3.network

import com.example.assignment3.models.ContactList
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ContactClient {
    private const val ROOT_URL = "https://randomuser.me/api/"
    private val interceptor = HttpLoggingInterceptor()

    private fun getClient(): OkHttpClient {
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    private var retrofitInstance: Retrofit? = null
        get() = Retrofit.Builder()
            .baseUrl(ROOT_URL)
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private fun getRandomUserService(): RandomUserService {
        return retrofitInstance!!.create(RandomUserService::class.java)
    }

    fun getContacts(num: Int): Call<ContactList> {
        return getRandomUserService().listContacts(num)
    }
}