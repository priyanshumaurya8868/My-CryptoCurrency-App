package com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.persentation.coin_list

import com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.domain.model.Coin

data class CoinListState(
    val isLoading :Boolean = false,
    val coins : List<Coin> = emptyList(),
    val error :String = ""
)
