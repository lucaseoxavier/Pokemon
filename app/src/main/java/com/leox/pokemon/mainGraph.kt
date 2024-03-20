package com.leox.pokemon

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.leox.pokemon.pokedex.ui.PokedexScreen
import com.leox.pokemon.pokedex.ui.PokedexViewModel

fun NavGraphBuilder.mainGraph() {
    composable(MainRoute.Root.route) {
        val viewModel: PokedexViewModel = hiltViewModel()
        PokedexScreen(viewModel)
    }
}

sealed class MainRoute(val route: String) {
    data object Root : MainRoute("mainScreen")
}