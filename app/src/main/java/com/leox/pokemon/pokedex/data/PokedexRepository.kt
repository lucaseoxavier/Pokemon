package com.leox.pokemon.pokedex.data

import android.util.Log
import com.leox.pokemon.common.network.PokeApi
import com.leox.pokemon.common.utils.GenericResult
import javax.inject.Inject

class PokedexRepository @Inject constructor(
    private val pokeApi: PokeApi,
) {
    suspend fun getPokedex(offset: Int, limit: Int): GenericResult<PokemonResponse?> {
        return try {
            val response = pokeApi.getPokedex(offset = offset, limit = limit)
            if (response.isSuccessful) {
                GenericResult.Success(response.body())
            } else {
                Log.e(TAG, "getPokedex failed: ${response.errorBody()}")
                GenericResult.GenericError(response.errorBody())
            }
        } catch (e: Exception) {
            Log.e(TAG, "error: ", e.cause)
            GenericResult.GenericError(null)
        }
    }

    companion object {
        private val TAG = this::class.java.simpleName
    }
}