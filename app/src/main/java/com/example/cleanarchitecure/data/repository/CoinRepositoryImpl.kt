package com.example.cleanarchitecure.data.repository

import com.example.cleanarchitecure.data.remote.CoinPaprikaApi
import com.example.cleanarchitecure.data.remote.dto.CoinDetailDto
import com.example.cleanarchitecure.data.remote.dto.CoinDto
import com.example.cleanarchitecure.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) :CoinRepository{
    override suspend fun getCoinById(coinId: String): CoinDetailDto {
       return api.getCoinById(coinId)
    }

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }
}