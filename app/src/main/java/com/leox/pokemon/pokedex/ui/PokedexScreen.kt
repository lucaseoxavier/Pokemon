package com.leox.pokemon.pokedex.ui

import androidx.compose.runtime.Composable

@Composable
fun PokedexScreen(viewModel: PokedexViewModel) {
    viewModel.fetchPokedex()
}