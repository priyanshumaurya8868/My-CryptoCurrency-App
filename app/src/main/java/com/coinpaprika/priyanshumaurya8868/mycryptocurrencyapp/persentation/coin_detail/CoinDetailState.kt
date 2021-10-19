package com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.persentation.coin_detail

import com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState (
    val isLoading :Boolean = false,
    val coin: CoinDetail? = null,
    val error :String = ""
    )