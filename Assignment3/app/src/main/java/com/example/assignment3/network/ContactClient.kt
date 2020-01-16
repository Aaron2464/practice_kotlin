package com.example.assignment3.network

import com.example.assignment3.models.ContactList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

 object ContactClient {
    private val ROOT_URL = "https://randomuser.me/api/"

    private var retrofitInstance: Retrofit? = null
        get() = Retrofit.Builder()
            .baseUrl(ROOT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private fun getRandomUserService():RandomUserService{
        return retrofitInstance!!.create(RandomUserService::class.java)
    }

    fun getContacts(num: Int): Call<ContactList> {
        return getRandomUserService().listContacts(num)
    }
}