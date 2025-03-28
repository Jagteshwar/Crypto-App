package com.jagteshwar.cryptoapp.domain.usecases.get_coin

import com.jagteshwar.cryptoapp.data.remote.dto.toCoinDetail
import com.jagteshwar.cryptoapp.domain.model.CoinDetail
import com.jagteshwar.cryptoapp.domain.repository.CoinRepository
import com.jagteshwar.cryptoapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoin @Inject constructor(
    private val coinRepository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>>  = flow{
        try {
        emit(Resource.Loading())
        val coin = coinRepository.getCoinById(coinId).toCoinDetail()
        emit(Resource.Success(coin))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage))
        }catch (e: IOException){
            emit(Resource.Error(e.localizedMessage))
        }
    }
}