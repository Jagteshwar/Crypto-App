package com.jagteshwar.cryptoapp.domain.usecases.get_coins

import com.jagteshwar.cryptoapp.data.remote.dto.toCoin
import com.jagteshwar.cryptoapp.domain.model.Coin
import com.jagteshwar.cryptoapp.domain.repository.CoinRepository
import com.jagteshwar.cryptoapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

class GetCoins @Inject constructor(
    private val coinRepository: CoinRepository
) {

    suspend operator fun invoke(): List<Coin> {
        val coinList = coinRepository.getCoins().map { it.toCoin() }
        return coinList
        //  emit(Resource.Success(coinList))

    }
}