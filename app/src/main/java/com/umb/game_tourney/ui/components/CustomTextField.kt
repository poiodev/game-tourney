package com.umb.game_tourney.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun CustomTextField(value: String, onValueChange: (String) -> Unit, label: String) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label, color = Color.White) },
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.White,          // Color del texto cuando está enfocado
            unfocusedTextColor = Color.White,       // Color del texto cuando no está enfocado
            focusedContainerColor = Color.Transparent, // Color del contenedor cuando está enfocado
            unfocusedContainerColor = Color.Transparent, // Color del contenedor cuando no está enfocado
            cursorColor = Color.White,              // Color del cursor
            focusedLabelColor = Color.White,        // Color de la etiqueta cuando está enfocado
            unfocusedLabelColor = Color.White      // Color de la etiqueta cuando no está enfocado
        )
    )
}