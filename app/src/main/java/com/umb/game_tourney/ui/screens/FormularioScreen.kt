package com.umb.game_tourney.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.umb.game_tourney.ui.components.CustomButton
import com.umb.game_tourney.ui.components.CustomTextField
import com.umb.game_tourney.ui.components.RadioButtonGroup

@Composable
fun FormularioScreen(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var juegoSeleccionado by remember { mutableStateOf("") }
    var nivelSeleccionado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .padding(16.dp)
    ) {
        CustomTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = "Nombre de Usuario"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Selecciona un juego:", color = Color.White)
        RadioButtonGroup(
            options = listOf("League of Legends", "Fornite", "Halo"),
            selectedOption = juegoSeleccionado,
            onOptionSelected = { juegoSeleccionado = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Nivel de experiencia:", color = Color.White)
        RadioButtonGroup(
            options = listOf("Principiante", "Intermedio", "Avanzado"),
            selectedOption = nivelSeleccionado,
            onOptionSelected = { nivelSeleccionado = it }
        )
        Spacer(modifier = Modifier.height(32.dp))
        CustomButton(text = "Registrarse") {
            navController.navigate("confirmacion/$nombre/$juegoSeleccionado/$nivelSeleccionado")
        }
    }
}