package com.jagteshwar.cryptoapp.data.remote

import com.jagteshwar.cryptoapp.data.remote.dto.CoinDetailDto
import com.jagteshwar.cryptoapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}