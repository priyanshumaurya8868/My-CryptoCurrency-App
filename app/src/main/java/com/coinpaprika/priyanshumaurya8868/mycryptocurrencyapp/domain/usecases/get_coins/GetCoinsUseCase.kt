package com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.domain.usecases.get_coins

import com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.common.Resource
import com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.domain.model.Coin
import com.coinpaprika.priyanshumaurya8868.mycryptocurrencyapp.domain.repository.CoinRepository
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow{
        try {
            emit(Resource.Loading<List<Coin>>())
            val  coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        }catch (e:HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage?: "An unexpected error occured"))
        }catch (e: IOException){
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection."))
        }
    }
}