package com.example.assignment3.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Contact(
    @SerializedName("gender")
    @Expose
    val gender: String,
    @SerializedName("name")
    @Expose
    val name: Name,
//    @SerializedName("location")
//    @Expose
//    private val location: Location,
    @SerializedName("email")
    @Expose
    val email: String,
    @SerializedName("cell")
    @Expose
    val cell: String
)

data class Name(
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("first")
    @Expose
    val first: String,
    @SerializedName("last")
    @Expose
    val last: String
)

//data class Location(
//    @SerializedName("street")
//    @Expose
//    private val street: String? = null,
//    @SerializedName("city")
//    @Expose
//    private val city: String? = null,
//    @SerializedName("state")
//    @Expose
//    private val province: String? = null,
//    @SerializedName("postcode")
//    @Expose
//    private val postcode: String? = null
//)