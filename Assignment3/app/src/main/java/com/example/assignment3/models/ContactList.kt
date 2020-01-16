package com.example.assignment3.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class ContactList {
    @SerializedName("results")
    @Expose
    var contactList: ArrayList<Contact>? = null
}