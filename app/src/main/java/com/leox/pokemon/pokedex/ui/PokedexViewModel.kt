package com.leox.pokemon.pokedex.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leox.pokemon.common.utils.GenericResult
import com.leox.pokemon.pokedex.data.PokedexRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class PokedexViewModel @Inject constructor(
    private val repository: PokedexRepository
) : ViewModel() {

    fun fetchPokedex() {
        runBlocking {
            val result = repository.getPokedex(0, 20)
            when (result) {
                is GenericResult.Success -> {
                    val pokemonResponse = result.data
                    Log.i("pokemonResponse", "${pokemonResponse}")
                }
                is GenericResult.GenericError -> {
                    val errorBody = result.errorBody
                    Log.e("pokemonResponse", "${errorBody}")
                }
            }
        }
    }
}