package com.example.cleanarchitecure.presentation.coin_detail.components

import com.example.cleanarchitecure.domain.model.Coin
import com.example.cleanarchitecure.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading :Boolean = false,
    val coin : CoinDetail? = null,
    val error :String = ""
)