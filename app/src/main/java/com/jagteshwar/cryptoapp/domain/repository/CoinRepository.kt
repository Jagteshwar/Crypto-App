package com.jagteshwar.cryptoapp.domain.repository

import com.jagteshwar.cryptoapp.data.remote.dto.CoinDetailDto
import com.jagteshwar.cryptoapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}