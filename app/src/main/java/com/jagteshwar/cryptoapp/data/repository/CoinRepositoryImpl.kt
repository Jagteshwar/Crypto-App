package com.jagteshwar.cryptoapp.data.repository

import com.jagteshwar.cryptoapp.data.remote.CoinApi
import com.jagteshwar.cryptoapp.data.remote.dto.CoinDetailDto
import com.jagteshwar.cryptoapp.data.remote.dto.CoinDto
import com.jagteshwar.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinApi: CoinApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return coinApi.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return coinApi.getCoinById(coinId = coinId)
    }
}