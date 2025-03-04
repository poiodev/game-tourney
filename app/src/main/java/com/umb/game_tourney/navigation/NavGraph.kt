package com.umb.game_tourney.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.umb.game_tourney.ui.screens.ConfirmationScreen
import com.umb.game_tourney.ui.screens.FormularioScreen
import com.umb.game_tourney.ui.screens.MainScreen
import com.umb.game_tourney.ui.screens.TorneoInfoScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") { MainScreen(navController) }
        composable("formulario") { FormularioScreen(navController) }
        composable("confirmacion/{nombre}/{juego}/{nivel}") { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
            val juego = backStackEntry.arguments?.getString("juego") ?: ""
            val nivel = backStackEntry.arguments?.getString("nivel") ?: ""
            ConfirmationScreen(navController, nombre, juego, nivel)
        }
        composable("torneoInfo") { TorneoInfoScreen(navController) }
    }
}