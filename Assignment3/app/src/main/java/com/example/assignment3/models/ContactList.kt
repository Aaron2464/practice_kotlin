package com.example.assignment3.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ContactList(
    @SerializedName("results")
    @Expose
    var contactList: ArrayList<Contact>
)