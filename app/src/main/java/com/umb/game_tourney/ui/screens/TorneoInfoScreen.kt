package com.umb.game_tourney.ui.screens

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.umb.game_tourney.ui.components.CustomButton
import kotlinx.coroutines.delay
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@SuppressLint("ContextCastToActivity")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TorneoInfoScreen(navController: NavController) {
    // Fecha y hora de inicio del torneo (puedes cambiarla)
    val fechaInicio = LocalDateTime.of(2025, 12, 15, 18, 0)  // 15 de diciembre de 2023, 6:00 PM
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")

    // Estado para el contador
    var tiempoRestante by remember { mutableStateOf(calcularTiempoRestante(fechaInicio)) }

    val activity = LocalContext.current as? Activity // ✅ Obtiene el contexto fuera del onClick
    // Actualizar el contador cada segundo
    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)
            tiempoRestante = calcularTiempoRestante(fechaInicio)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "El torneo comienza el:",
            color = Color.White,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = fechaInicio.format(formatter),
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Tiempo restante:",
            color = Color.White,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = tiempoRestante,
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(32.dp))
        CustomButton(text = "Salir") {
            activity?.finish() // ✅ Usa el contexto ya obtenido
        }
    }
}

// Función para calcular el tiempo restante
@RequiresApi(Build.VERSION_CODES.O)
fun calcularTiempoRestante(fechaInicio: LocalDateTime): String {
    val ahora = LocalDateTime.now()
    val diferencia = java.time.Duration.between(ahora, fechaInicio)

    return if (diferencia.isNegative) {
        "¡El torneo ya comenzó!"
    } else {
        val dias = diferencia.toDays()
        val horas = diferencia.toHours() % 24
        val minutos = diferencia.toMinutes() % 60
        val segundos = diferencia.seconds % 60
        "$dias días, $horas horas, $minutos minutos, $segundos segundos"
    }
}