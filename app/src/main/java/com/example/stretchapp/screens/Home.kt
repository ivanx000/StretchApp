package com.example.stretchapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.Ccompose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Home(
    onStartClicked: () -> Unit,
    modifier: Modifier = Modifier // <-- add this line
) {
    Box(
        modifier = modifier.fillMaxSize(), // use the passed modifier
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Welcome to the stretching app",
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = onStartClicked) {
                Text(text = "Start")
            }
        }
    }
}
