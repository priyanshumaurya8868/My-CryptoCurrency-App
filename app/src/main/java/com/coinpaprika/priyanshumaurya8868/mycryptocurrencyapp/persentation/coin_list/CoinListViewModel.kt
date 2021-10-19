package com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.persentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.common.Resource
import com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.domain.usecases.get_coins.GetCoinsUseCase
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase : GetCoinsUseCase
):ViewModel() {
    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins(){
        getCoinsUseCase().onEach { result->
            when(result){
                is Resource.Loading->{
                    _state.value = CoinListState(true)
                }
                is Resource.Success->{
                    _state.value = CoinListState(coins = result.data?: emptyList())
                }
                is Resource.Error->{
                    _state.value = CoinListState(error=result.message?:"An Unexpected error Occured")
                }
            }

        }.launchIn(viewModelScope)
    }


}