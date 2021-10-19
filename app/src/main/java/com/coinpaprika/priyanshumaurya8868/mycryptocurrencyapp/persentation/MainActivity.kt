package com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.persentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.persentation.coin_detail.CoinDetailScreen
import com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.persentation.coin_list.CoinListScreen
import com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.persentation.ui.theme.CryptocurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(route = Screen.CoinListScreen.route){
                            CoinListScreen(navController)
                        }
// typo  matters in  uri/path. It should be as same as  variable's  name
                        composable(route =Screen.CoinDetailScreen.route+"/{coinId}"){
                            CoinDetailScreen()
                        }
                    }

                }
            }
        }
    }
}


