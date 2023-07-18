package com.example.cleanarchitecure.domain.use_case.get_coins

import com.example.cleanarchitecure.common.Resource
import com.example.cleanarchitecure.data.remote.dto.toCoin
import com.example.cleanarchitecure.domain.model.Coin
import com.example.cleanarchitecure.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
     operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
         try {
emit(Resource.Loading<List<Coin>>())
             //list of coins
             val coins = repository.getCoins().map { it.toCoin() }
             emit(Resource.Success<List<Coin>>(coins))
         } catch (e: HttpException) {
emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occured."))
         }catch (E:IOException){
             emit(Resource.Error<List<Coin>>("Couldn't reach server.Check your internet connection."))

         }
     }
}