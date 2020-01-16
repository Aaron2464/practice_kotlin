package com.example.assignment3.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Contact {
    @SerializedName("gender")
    @Expose
    private val gender: String? = null
    @SerializedName("name")
    @Expose
    private val name: Name? = null
    @SerializedName("location")
    @Expose
    private val location: Location? = null
    @SerializedName("email")
    @Expose
    private val email: String? = null
    @SerializedName("cell")
    @Expose
    private val cell: String? = null

    class Name {
        @SerializedName("first")
        @Expose
        private val first: String? = null
        @SerializedName("last")
        @Expose
        private val last: String? = null
    }

    class Location {
        @SerializedName("street")
        @Expose
        private val street: String? = null
        @SerializedName("city")
        @Expose
        private val city: String? = null
        @SerializedName("state")
        @Expose
        private val province: String? = null
        @SerializedName("postcode")
        @Expose
        private val postcode: String? = null
    }
}