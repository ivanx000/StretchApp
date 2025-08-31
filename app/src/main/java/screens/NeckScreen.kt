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
fun NeckScreen(navController: NavHostController) {
    val videos = listOf(
        VideoItem("yt3CpkmFAfc", "Neck Stretch 1"),
        VideoItem("WjMwXDgdgwI", "Neck Stretch 2"),
        VideoItem("H5h54Q0wpps", "Neck Stretch 3"),
        VideoItem("was4RtzpfJs", "Neck Stretch 4"),
        VideoItem("ekLJMzJWZU4", "Neck Stretch 5"),
        VideoItem("5lbe9oZbpDs", "Neck Stretch 6"),
        VideoItem("Mbpqjr5HMoE", "Neck Stretch 7")
    )

    var selectedVideo by remember { mutableStateOf<VideoItem?>(null) }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Neck Stretches",
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
