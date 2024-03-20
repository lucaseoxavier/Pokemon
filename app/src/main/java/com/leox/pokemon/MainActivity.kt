package com.leox.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.leox.pokemon.pokedex.ui.PokedexViewModel
import com.leox.pokemon.ui.theme.PokemonTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val pokedexViewModel: PokedexViewModel by viewModels()

            PokemonTheme {
                NavHost(navController = navController, startDestination = MainRoute.Root.route) {
                    mainGraph()
                }
            }
        }
    }
}

