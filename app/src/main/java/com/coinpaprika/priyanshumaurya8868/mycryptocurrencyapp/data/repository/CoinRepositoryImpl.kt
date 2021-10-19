package com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.data.repository

import com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.data.remote.CoinPaprikaApi
import com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.domain.repository.CoinRepository
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDto
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api :CoinPaprikaApi) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto>  = api.getCoins()


    override suspend fun getCoinById(coinId: String): CoinDetailDto  = api.getCoinById(coinId)
}
//TODO persistence