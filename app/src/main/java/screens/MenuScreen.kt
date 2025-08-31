package com.example.stretchingapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun MenuScreen(navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(onClick = { navController.navigate("leg") }) {
            Text("Leg Stretches", fontSize = 18.sp)
        }
        Button(onClick = { navController.navigate("neck") }) {
            Text("Neck Stretches", fontSize = 18.sp)
        }
        Button(onClick = { navController.navigate("torso") }) {
            Text("Torso Stretches", fontSize = 18.sp)
        }
    }
}
