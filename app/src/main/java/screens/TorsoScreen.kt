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
fun TorsoScreen(navController: NavHostController) {
    // List of torso stretch videos
    val videos = listOf(
        VideoItem("A7sKXLRB4iY", "Chest Stretch"),
        VideoItem("UYMmtEFhuxA", "Back Stretch"),
        VideoItem("eJhn8YzH_8I", "Ab Stretch"),
        VideoItem("-KPXtlEYVPM", "Side Stretch"),
        VideoItem("W2zsmiJ9Lpk", "Torso Twist"),
        VideoItem("sgO7BK6fxK4", "Lower Back"),
        VideoItem("VSJUfWO6Zv8", "Oblique Stretch")
    )

    var selectedVideo by remember { mutableStateOf<VideoItem?>(null) }

    Column(modifier = Modifier.fillMaxSize()) {
        // Title
        Text(
            text = "Torso",
            fontSize = 28.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        // Scrollable list of videos
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

        // Back button
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Back")
        }
    }

    // Dialog to play selected video
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
