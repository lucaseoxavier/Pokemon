package com.leox.pokemon

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.leox.pokemon.pokedex.ui.PokedexScreen

fun NavGraphBuilder.mainGraph() {
    composable(MainRoute.Root.route) {
        PokedexScreen()
    }
}

sealed class MainRoute(val route: String) {
    data object Root : MainRoute("mainScreen")
}