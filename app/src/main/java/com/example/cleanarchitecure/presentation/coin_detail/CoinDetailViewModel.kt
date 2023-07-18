package com.example.cleanarchitecure.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecure.common.Constants
import com.example.cleanarchitecure.common.Resource
import com.example.cleanarchitecure.domain.use_case.get_coin.GetCoinUseCase
import com.example.cleanarchitecure.domain.use_case.get_coins.GetCoinsUseCase
import com.example.cleanarchitecure.presentation.coin_detail.components.CoinDetailState
import com.example.cleanarchitecure.presentation.coin_list.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase:GetCoinUseCase,
    savedStateHandle: SavedStateHandle
    ) : ViewModel() {

        //don't want to be able to modify the content of state in composable.
        //that's why access only mutable state in the viewModel
        private val _state = mutableStateOf(CoinDetailState())
//expose this immutable state to composable
        val state: State<CoinDetailState> = _state
        init {
          savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId->
              getCoin(coinId)
          }
        }
        //executes the use case  and puts the result simply into state object
        //that we'll have for composable
        private fun getCoin(coinId :String){
            getCoinUseCase(coinId).onEach { result->
                when(result){
                    is Resource.Success ->{
                        _state.value = CoinDetailState(coin =  result.data )
                    }
                    is Resource.Error ->{
                        _state.value = CoinDetailState(error = result.message?: "An unexpected error occured." )

                    }
                    is Resource.Loading ->{
                        _state.value = CoinDetailState(isLoading = true)
                    }
                }

            }.launchIn(viewModelScope)
        }
    }