package com.leox.pokemon.pokedex.ui

import android.util.Log
import androidx.compose.runtime.Composable
import com.leox.pokemon.common.network.RetrofitBuilder
import com.leox.pokemon.common.utils.GenericResult
import com.leox.pokemon.pokedex.data.PokedexRepository
import kotlinx.coroutines.runBlocking

@Composable
fun PokedexScreen() {
    fetchPokedex()
}

fun fetchPokedex() {
    val repository = PokedexRepository(RetrofitBuilder.apiService)

    runBlocking {
        val result = repository.getPokedex(0, 20)
        when (result) {
            is GenericResult.Success -> {
                val pokemonResponse = result.data
                Log.i("pokemonResponse", "${pokemonResponse}")
            }
            is GenericResult.GenericError -> {
                val errorBody = result.errorBody
            }
        }
    }
}