package com.jagteshwar.cryptoapp.presentation.get_coins

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jagteshwar.cryptoapp.domain.model.Coin
import com.jagteshwar.cryptoapp.domain.usecases.get_coins.GetCoins
import com.jagteshwar.cryptoapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetCoinsViewModel @Inject constructor(
    private val getCoins: GetCoins
): ViewModel(){

    private var _listState = mutableStateOf<List<Coin>>(emptyList())
    val listState: State<List<Coin>> = _listState


    init {
//        getCoinsList()
        viewModelScope.launch {
        _listState.value = getCoins().filter { it.name.contains("Eth") }
        }
    }
//    private fun getCoinsList(){
//        getCoins().onEach {
//            when(it){
//                is Resource.Error -> TODO()
//                is Resource.Loading -> TODO()
//                is Resource.Success -> {
//                    _listState.emit(it.data ?: emptyList())
//                    Log.i("Crypto App" , "view model class: ${it.data}")
//                }
//            }
//        }.launchIn(viewModelScope)
//    }
}