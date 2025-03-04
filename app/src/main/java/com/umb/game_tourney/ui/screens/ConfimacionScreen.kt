package com.umb.game_tourney.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import com.umb.game_tourney.ui.components.CustomButton

@Composable
fun ConfirmationScreen(navController: NavController, nombre: String, juego: String, nivel: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "¡Gracias, $nombre! Estás registrado para $juego como $nivel.",
            color = Color.White,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(32.dp))
        CustomButton(text = "Continuar") {
            navController.navigate("torneoInfo")  // Navega a la nueva pantalla
        }
    }
}