package com.apolis.sendobjecttoactivityb34

import java.io.Serializable

data class Product (
    val pName: String,
    val category: String,
    val price: Float,
    val userRating: Float
): Serializable