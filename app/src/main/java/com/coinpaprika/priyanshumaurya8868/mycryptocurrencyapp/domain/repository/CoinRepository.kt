package com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.domain.repository

import com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun  getCoins() : List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

}