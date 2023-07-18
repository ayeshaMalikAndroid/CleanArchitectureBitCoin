package com.example.cleanarchitecure.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecure.common.Resource
import com.example.cleanarchitecure.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CoinsListViewModel @Inject constructor(

    private val getCoinsUseCase: GetCoinsUseCase
) :ViewModel() {

    //don't want to be able to modify the content of state in composable.
    //that's why access only mutable state in the viewModel
    private val _state = mutableStateOf<CoinListState>(CoinListState())
//expose this immutable state to composable
    val state: State<CoinListState> = _state
init {
    getCoins()
}
    //executes the usecase  and puts the result simply into state object
    //that we'll have for composable
private fun getCoins(){
    getCoinsUseCase().onEach { result->
        when(result){
            is Resource.Success ->{
_state.value = CoinListState(coins =  result.data ?: emptyList())
            }
            is Resource.Error ->{
                _state.value = CoinListState(error = result.message?: "An unexpected error occured." )

            }
            is Resource.Loading ->{
                _state.value = CoinListState(isLoading = true)
            }
        }

    }.launchIn(viewModelScope)
}
}