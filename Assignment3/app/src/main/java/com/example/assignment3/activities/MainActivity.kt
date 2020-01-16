package com.example.assignment3.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment3.models.Contact
import com.example.assignment3.models.ContactList
import com.example.assignment3.network.ContactClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity :AppCompatActivity(){
    private var mContactList: ArrayList<Contact>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val call: Call<ContactList> = ContactClient.getContacts(10)
        call.enqueue(object: Callback<ContactList>{
            override fun onResponse(call: Call<ContactList>, response: Response<ContactList>) {
                if(response.isSuccessful){
                    mContactList = response.body()?.contactList
                    for (contact in mContactList!!){
                        Log.d("TAG", "onResponse: " + mContactList!!.size)
                        Log.d("TAG", "onResponse: $contact")
                    }
                }
            }
            override fun onFailure(call: Call<ContactList>, t: Throwable) {

            }
        })
    }
}