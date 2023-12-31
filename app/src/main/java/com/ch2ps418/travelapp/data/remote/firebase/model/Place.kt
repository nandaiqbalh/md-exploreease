package com.ch2ps418.travelapp.data.remote.firebase.model

import java.io.Serializable

data class Place(
    val Place_Id: Int,
    val Photos: String,
    val Place_Name: String,
    val Category: String,
    val City: String,
    val Lat: Double,
    val Long: Double,
    val Price: Int,
    val Rating: Double
) : Serializable