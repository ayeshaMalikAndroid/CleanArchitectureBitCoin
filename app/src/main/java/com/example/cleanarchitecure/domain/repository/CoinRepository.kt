package com.example.cleanarchitecure.domain.repository

import com.example.cleanarchitecure.data.remote.dto.CoinDetailDto
import com.example.cleanarchitecure.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinById(coinId :String) : CoinDetailDto
}