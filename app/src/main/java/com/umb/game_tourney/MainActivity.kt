package com.umb.game_tourney

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.umb.game_tourney.navigation.NavGraph
import com.umb.game_tourney.ui.theme.GameTourneyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameTourneyTheme {
                NavGraph()
            }
        }
    }
}