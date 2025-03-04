package com.umb.game_tourney.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick, // ✅ Ahora tiene el tipo correcto
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
    ) {
        Text(text = text, color = Color.White)
    }
}
