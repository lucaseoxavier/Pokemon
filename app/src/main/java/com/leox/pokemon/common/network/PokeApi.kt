package com.leox.pokemon.common.network

import com.leox.pokemon.pokedex.data.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApi {

    @GET("pokemon")
    suspend fun getPokedex(@Query("offset") offset: Int, @Query("limit") limit: Int) : Response<PokemonResponse>
}