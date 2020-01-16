package com.example.assignment3.network

import com.example.assignment3.models.ContactList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUserService {
    @GET("?nat=ca")
    fun listContacts(@Query("results") num:Int):Call<ContactList>

}