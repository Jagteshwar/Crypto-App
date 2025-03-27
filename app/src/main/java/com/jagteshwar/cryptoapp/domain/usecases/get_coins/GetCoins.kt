package com.jagteshwar.cryptoapp.domain.usecases.get_coins

import com.jagteshwar.cryptoapp.data.remote.dto.toCoin
import com.jagteshwar.cryptoapp.domain.model.Coin
import com.jagteshwar.cryptoapp.domain.repository.CoinRepository
import com.jagteshwar.cryptoapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoins @Inject constructor(
    private val coinRepository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = coinRepository.getCoins()
            emit(Resource.Success(coins.map { it.toCoin() }))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    e.localizedMessage ?: "Couldn't reach server. Check your internet connection.."
                )
            )
        }

    }
}