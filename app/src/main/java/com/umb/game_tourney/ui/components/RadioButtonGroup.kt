package com.umb.game_tourney.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RadioButtonGroup(options: List<String>, selectedOption: String, onOptionSelected: (String) -> Unit) {
    Column {
        options.forEach { option ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                RadioButton(
                    selected = (option == selectedOption),
                    onClick = { onOptionSelected(option) },
                    colors = RadioButtonDefaults.colors(selectedColor = Color.Blue)
                )
                Text(text = option, color = Color.White, modifier = Modifier.padding(start = 8.dp))
            }
        }
    }
}