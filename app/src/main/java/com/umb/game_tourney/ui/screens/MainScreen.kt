package com.umb.game_tourney.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.umb.game_tourney.R
import com.umb.game_tourney.ui.theme.*

@Composable
fun MainScreen(navController: NavController) {
    // Animación para el brillo del logo
    val infiniteTransition = rememberInfiniteTransition()
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0.3f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF121212), Color(0xFF000000))
                )
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Logo con efecto de brillo
        Box(
            modifier = Modifier
                .padding(bottom = 32.dp)
                .graphicsLayer(alpha = alpha)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_torneo),
                contentDescription = "Logo del torneo",
                modifier = Modifier.size(250.dp)
            )
        }

        // Botón "Comenzar" con estilo moderno
        Button(
            onClick = { navController.navigate("formulario") },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(60.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6200EE),
                contentColor = Color.White
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 8.dp,
                pressedElevation = 4.dp
            )
        ) {
            Text(
                text = "Comenzar",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}