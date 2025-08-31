package com.example.stretchingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.stretchingapp.screens.HomeScreen
import com.example.stretchingapp.screens.MenuScreen
import com.example.stretchingapp.screens.LegScreen
import com.example.stretchingapp.screens.NeckScreen
import com.example.stretchingapp.screens.TorsoScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "home") {
                composable("home") { HomeScreen(navController) }
                composable("menu") { MenuScreen(navController) }
                composable("leg") { LegScreen(navController) }
                composable("neck") { NeckScreen(navController) }
                composable("torso") { TorsoScreen(navController) }
            }
        }
    }
}
