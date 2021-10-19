package com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.persentation

sealed class Screen(val route : String){
    object CoinListScreen :Screen("coin_list_screen")
    object CoinDetailScreen :Screen("coin_detail_screen")
}
