package com.example.dependancyinjection_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dependancyinjection_2.ui.theme.DependancyInjection_2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DependancyInjection_2Theme {
                NavComponent()
            }
        }
    }
}

@Composable
fun NavComponent(){

    val navController = rememberNavController() // to define the state of the navigation

    NavHost(navController = navController, startDestination = "Screen1")
    {
        composable("Screen1") {
            AmineUI(navController = navController)
        }

        composable("Screen2/{characterName}/{characterSpecies}/{characterType}/{characterID}") {  backStackEntry ->
            val characterName = backStackEntry.arguments?.getString("characterName") ?: ""
            val characterSpecies = backStackEntry.arguments?.getString("characterSpecies") ?: ""
            val characterType = backStackEntry.arguments?.getString("characterType") ?: ""
            val characterID = backStackEntry.arguments?.getString("characterID") ?: ""
            ProfileUI(navController = navController,  characterName= characterName, characterSpecies = characterSpecies,
                characterType = characterType,  characterID= characterID)
        }
    }
}

