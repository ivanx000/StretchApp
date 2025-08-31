package com.example.stretchingapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.stretchingapp.screens.VideoItem
import com.example.stretchingapp.screens.VideoCard
import com.example.stretchingapp.screens.YouTubePlayer


@Composable
fun LegScreen(navController: NavHostController) {
    val videos = listOf(
        VideoItem("FX-R98zU5MI", "Hamstring Stretch"),
        VideoItem("R6t5tyYGaDg", "Quad Stretch"),
        VideoItem("IMS65Ft-nY0", "Calf Stretch"),
        VideoItem("eRCpceBhcm0", "Glute Stretch"),
        VideoItem("UrHcQJCqo4Q", "Hip Flexor Stretch"),
        VideoItem("dJvw6reGKKk", "IT Band Stretch"),
        VideoItem("ANue9qDFg90", "Adductor Stretch")
    )

    var selectedVideo by remember { mutableStateOf<VideoItem?>(null) }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Leg Stretches",
            fontSize = 28.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(videos.size) { index ->
                VideoCard(video = videos[index]) {
                    selectedVideo = it
                }
            }
        }

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Back")
        }
    }

    if (selectedVideo != null) {
        AlertDialog(
            onDismissRequest = { selectedVideo = null },
            confirmButton = {
                TextButton(onClick = { selectedVideo = null }) {
                    Text("Close")
                }
            },
            text = {
                YouTubePlayer(videoId = selectedVideo!!.videoId)
            }
        )
    }
}
