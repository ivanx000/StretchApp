package com.example.stretchingapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(navController: NavHostController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp) // space between text and button
        ) {
            Text(text = "Welcome to the Stretching App!", fontSize = 24.sp) // larger welcome text
            Button(onClick = { navController.navigate("menu") }) {
                Text(text = "Go to Menu", fontSize = 18.sp)
            }
        }
    }
}
