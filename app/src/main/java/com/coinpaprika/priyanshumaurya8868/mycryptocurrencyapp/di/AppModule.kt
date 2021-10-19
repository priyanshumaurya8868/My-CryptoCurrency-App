package com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.di

import com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.common.Constants
import com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.data.remote.CoinPaprikaApi
import com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.data.repository.CoinRepositoryImpl
import com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.domain.repository.CoinRepository
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
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepo(api: CoinPaprikaApi): CoinRepository = CoinRepositoryImpl(api)

}