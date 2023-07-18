package com.example.cleanarchitecure.domain.model


//data class that will just use to display specific data in our list.
data class Coin(
    val id: String,
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String
    )
