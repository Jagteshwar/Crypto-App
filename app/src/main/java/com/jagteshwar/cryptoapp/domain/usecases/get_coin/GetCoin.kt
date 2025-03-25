package com.jagteshwar.cryptoapp.domain.usecases.get_coin

import com.jagteshwar.cryptoapp.data.remote.dto.toCoinDetail
import com.jagteshwar.cryptoapp.domain.model.CoinDetail
import com.jagteshwar.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class GetCoin @Inject constructor(
    private val coinRepository: CoinRepository
) {

    suspend operator fun invoke(coinId: String): CoinDetail{
    return coinRepository.getCoinById(coinId).toCoinDetail()
    }
}