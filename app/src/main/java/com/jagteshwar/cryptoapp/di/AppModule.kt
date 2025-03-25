package com.jagteshwar.cryptoapp.di

import androidx.compose.ui.unit.Constraints
import com.jagteshwar.cryptoapp.data.remote.CoinApi
import com.jagteshwar.cryptoapp.data.repository.CoinRepositoryImpl
import com.jagteshwar.cryptoapp.domain.repository.CoinRepository
import com.jagteshwar.cryptoapp.domain.usecases.get_coins.GetCoins
import com.jagteshwar.cryptoapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinApi(): CoinApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinApi): CoinRepository = CoinRepositoryImpl(api)

    @Provides
    @Singleton
    fun providesGetCoinsUseCase(coinRepository: CoinRepository) = GetCoins(coinRepository)
}